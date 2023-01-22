/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises

import com.stulsoft.swing.exercises.TextInputDialog.label

import java.awt.BorderLayout
import javax.swing.JOptionPane
import scala.swing.*
import scala.swing.BorderPanel.Position
import scala.swing.Dialog.{Message, showInput}
import scala.swing.event.*

object TextInputDialog extends SimpleSwingApplication:
  private lazy val label = new Label("Результата еще нет")
  private lazy val button = new Button {
    text = "Вызови диалог"
  }


  private lazy val ui: Panel = new BoxPanel(Orientation.Vertical) {
    contents += button
    contents += label

    listenTo(button)

    reactions += {
      case ButtonClicked(_) =>
        val s = showInput(button,
          "Enter some text",
          "Input Text Dialog",
          Message.Plain,
          Swing.EmptyIcon,
          Nil, "Initial value")
        label.text = if (s.isDefined && s.get.nonEmpty) then
          "Result: " + s.get
        else
          "No result :("
    }
  }

  private lazy val ui0: Panel = new BorderPanel {
/*
    val label = new Label("TEST")
    layout(label) = Position.Center
*/
    val ui = new BoxPanel(Orientation.Vertical) {
      contents += button
      contents += label

      listenTo(button)

      reactions += {
        case ButtonClicked(_) =>
          val s = showInput(button,
            "Enter some text",
            "Input Text Dialog",
            Message.Plain,
            Swing.EmptyIcon,
            Nil, "Initial value")
          label.text = if (s.isDefined && s.get.nonEmpty) then
            "Result: " + s.get
          else
            "No result :("
      }
    }
    layout(ui) = Position.Center
  }

  override def top: Frame = new MainFrame {
    title = "Диалог текстового ввода"
    //    contents = ui
    contents = ui0
    size = new Dimension(400, 200)

    centerOnScreen()
  }