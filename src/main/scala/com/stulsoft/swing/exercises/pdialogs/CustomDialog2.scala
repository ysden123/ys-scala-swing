/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.pdialogs

import scala.swing.event.ButtonClicked
import scala.swing.*

object CustomDialog2 extends SimpleSwingApplication {
  override def top: Frame = new MainFrame {
    val theMainFrame = this
    title = "Custom dialog 2"

    contents = new FlowPanel() {
      contents += new Button("Call dialog") {
        reactions += {
          case ButtonClicked(_) =>
            val d: Dialog = new Dialog(theMainFrame) {
              def closeMe(): Unit = {
                dispose()
              }

              modal = true
              title = "The Dialog"
              size = new Dimension(200, 50)
              centerOnScreen()
              contents = new FlowPanel(FlowPanel.Alignment.Center)(
                new Label("The label"),
                new TextField(theMainFrame.title),
                new Button("Close me") {
                  reactions += {
                    case ButtonClicked(_) =>
                      closeMe()
                  }
                }
              )
            }
            d.visible = true
            println(s"After close")
        }
      }
    }
    size = new Dimension(300, 300)
    centerOnScreen()
  }
}
