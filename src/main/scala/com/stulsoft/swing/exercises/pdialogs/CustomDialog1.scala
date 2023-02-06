/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.pdialogs

import scala.swing.event.ButtonClicked
import scala.swing.{Button, Dialog, Dimension, FlowPanel, Frame, Label, MainFrame, SimpleSwingApplication, TextField, Window}

object CustomDialog1 extends SimpleSwingApplication {
  override def top: Frame = new MainFrame {
    val theMainFrame = this
    title = "Custom dialog1"

    contents = new FlowPanel() {
      contents += new Button("Call dialog") {
        reactions += {
          case ButtonClicked(_) =>
            new Dialog(theMainFrame){
              def closeMe():Unit={
                dispose()
              }
              title = "The Dialog"
              size = new Dimension(200, 50)
              centerOnScreen()
              contents = new FlowPanel(FlowPanel.Alignment.Center)(
                new Label("The label"),
                new TextField(theMainFrame.title),
                new Button("Close me"){
                  reactions += {
                    case ButtonClicked(_) => closeMe()
                  }
                }
              )
            }.open()
        }
      }
    }
    size = new Dimension(300, 300)
    centerOnScreen()
  }
}
