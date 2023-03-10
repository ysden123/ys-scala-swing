/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.pconcurrency

import javax.swing.SwingUtilities
import scala.concurrent.{Future, Promise}
import scala.swing.*
import scala.swing.Component.*
import scala.swing.event.*
import scala.util.{Failure, Success}


object ConcurrencyEx1 extends SimpleSwingApplication:
  given ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global
  override def top: Frame = new MainFrame {
    title = "ConcurrencyEx1"
    val l: Label = new Label("Initial text")
    val button: Button = new Button("Start") {
      reactions += {
        case ButtonClicked(_) =>
          l.text = "Started a long process..."
          enabled = false
          SwingUtilities.invokeLater(() => {
            LongWorkService.process().onComplete {
              case Success(result) =>
                l.text = result
                enabled = true
              case Failure(exception) =>
                l.text = s"Exception: ${exception.getMessage}"
                enabled = true
            }
          })
      }
    }

    contents = new FlowPanel(FlowPanel.Alignment.Center)(button, l)
    size = new Dimension(400, 600)
    centerOnScreen()
  }
end ConcurrencyEx1

object LongWorkService:
  given ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global
  private var counter = 0

  def process(): Future[String] =
    val promise = Promise[String]

    Future[String] {
      counter += 1
      if counter > 5 then
        throw new RuntimeException("Limit exhausted")
      else
        Thread.sleep(2_000)
        s"The text updated $counter times"
    }.onComplete {
      case Success(result) =>
        promise.success(result)
      case Failure(exception) =>
        promise.failure(exception)
    }

    promise.future
  end process
end LongWorkService
