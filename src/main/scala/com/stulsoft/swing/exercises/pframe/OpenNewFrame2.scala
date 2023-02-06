/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.pframe

import scala.swing.*
import scala.swing.event.ButtonClicked

object OpenNewFrame2 extends SimpleSwingApplication {

  override def top: Frame = new MainFrame {
    contents = new FlowPanel(FlowPanel.Alignment.Center)(new Button("Open my frame") {
      reactions += {
        case ButtonClicked(_) =>
          val myFrame = new MyFrame
          myFrame.open()
      }
    })

    title = "Open new frame 2"
    size = new Dimension(400, 400)
    centerOnScreen()
  }
}

class MyFrame() extends Frame {
  title = "MyFrame"

  size = new Dimension(350, 200)
  centerOnScreen()
}
