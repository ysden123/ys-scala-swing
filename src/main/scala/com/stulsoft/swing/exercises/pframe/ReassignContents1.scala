/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.pframe

import scala.swing.event.ButtonClicked
import scala.swing.{Button, Dimension, FlowPanel, Frame, MainFrame, SimpleSwingApplication}

object ReassignContents1  extends SimpleSwingApplication {
  override def top: Frame = new MainFrame {
    val mainFrame: MainFrame = this
    contents = new FlowPanel(FlowPanel.Alignment.Center)(new Button("Reassign"){
      reactions += {
        case ButtonClicked(_) =>
          mainFrame.contents = new MyPanel(mainFrame)
          mainFrame.size = new Dimension(400, 400)
          mainFrame.centerOnScreen()
      }
    })
    title = "Reassign contents"
    size = new Dimension(400, 400)
    centerOnScreen()
  }
}

class MyPanel(mainFrame: MainFrame) extends FlowPanel(FlowPanel.Alignment.Center)(new Button("Close"){
  reactions += {
    case ButtonClicked(_) =>
      mainFrame.dispose()
  }
})
