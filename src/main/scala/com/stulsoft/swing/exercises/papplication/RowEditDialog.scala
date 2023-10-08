/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.papplication

import scala.swing.BorderPanel.Position
import scala.swing.event.ButtonClicked
import scala.swing.{BorderPanel, Button, Dialog, Dimension, FlowPanel, Label, TextField, Window}

class RowEditDialog(owner: Window, name: String) extends Dialog(owner):
  var result: Option[String] = None
  private val dialogFrame: Dialog = this
  modal = true
  title = "Name editor"
  size = new Dimension(300, 300)
  resizable = false
  centerOnScreen()

  private val nameField = new TextField(name)

  private val okButton: Button = new Button("OK") {
    reactions += {
      case ButtonClicked(_) =>
        result = Some(nameField.text)
        dialogFrame.close()
    }
  }

  private val cancelButton: Button = new Button("Cancel") {
    reactions += {
      case ButtonClicked(_) =>
        result = None
        dialogFrame.close()
    }
  }

  val dataPanel = new FlowPanel(FlowPanel.Alignment.Center)(Array(new Label("Name:"), nameField): _*)
  val buttonPanel = new FlowPanel(FlowPanel.Alignment.Center)(Array(okButton, cancelButton): _*)

  defaultButton = okButton

  contents=new BorderPanel{
    layout(dataPanel) = Position.Center
    layout(buttonPanel) = Position.South
  }

end RowEditDialog

