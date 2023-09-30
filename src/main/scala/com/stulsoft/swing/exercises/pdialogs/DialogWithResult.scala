/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.pdialogs

import javax.swing.SwingUtilities
import scala.swing.BorderPanel.Position
import scala.swing.event.ButtonClicked
import scala.swing.*

object DialogWithResult extends SimpleSwingApplication:
  private case class MyResult(name: String, age: Int)

  private class MyDialog(owner: Window, data: MyResult) extends Dialog(owner):
    var result: Option[MyResult] = None
    modal = true
    title = "My Dialog"
    centerOnScreen()

    private val nameField = new TextField(data.name, 20)
    private val ageField = new TextField(data.age.toString, 10)
    private val dataPanel = new FlowPanel(FlowPanel.Alignment.Center)(
      new Label("Name: "),
      nameField,
      new Label("Age: "),
      ageField
    )

    private val okButton = new Button("OK") {
      reactions += {
        case ButtonClicked(_) =>
          result = Some(MyResult(nameField.text, ageField.text.toInt))
          dispose()
      }
    }

    private val cancelButton = new Button("Cancel") {
      reactions += {
        case ButtonClicked(_) =>
          result = None
          dispose()
      }
    }

    private val buttonPanel = new FlowPanel(FlowPanel.Alignment.Center)(
      okButton, cancelButton
    )

    defaultButton = okButton

    contents = new BorderPanel {
      layout(dataPanel) = Position.Center
      layout(buttonPanel) = Position.South
    }


  override def top: Frame = new MainFrame {
    private val theMainFrame: MainFrame = this
    title = "DialogWithResult"

    size = new Dimension(600, 300)
    centerOnScreen()

    SwingUtilities.invokeLater(()=>{
      val dialog = new MyDialog(theMainFrame, MyResult("initial name", 123))
      dialog.open()
      dialog.result.foreach(result => println(result))
    })

  }
