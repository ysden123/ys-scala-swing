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

object ConcurrencyEx2 extends SimpleSwingApplication {
  given ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global

  override def top: Frame = new MainFrame {
    title = "ConcurrencyEx2"
    val l: Label = new Label("Initial text")
    val button: Button = new Button("Start") {
      reactions += {
        case ButtonClicked(_) =>
          l.text = "Started a long process..."
          enabled = false
          SwingUtilities.invokeLater(() => {
            LongWorkService2.process(str => l.text = str).onComplete {
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
}

object LongWorkService2:
  given ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global
  private var counter = 0

  def process(callback: String => Unit ): Future[String] =
    val promise = Promise[String]

    Future[String] {
      for(_ <- 1 to 10){
        Thread.sleep(1_000)
        counter += 1
        callback(s"Counter = $counter")
      }
        s"The text updated $counter times"
    }.onComplete {
      case Success(result) =>
        promise.success(result)
      case Failure(exception) =>
        promise.failure(exception)
    }

    promise.future
  end process
end LongWorkService2

