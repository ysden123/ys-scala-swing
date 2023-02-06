/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.pframe

import scala.swing.*

object OpenNewFrame1 extends SimpleSwingApplication {
  private lazy val newFrame = new FlowPanel(FlowPanel.Alignment.Center)(new Button("Close new frame"))
  override def top: Frame = new MainFrame {
    contents = new FlowPanel(FlowPanel.Alignment.Center)(new Button("Open new frame") {
      newFrame.visible = true
    })

    title = "Open new frame 1"
    size = new Dimension(400, 400)
    centerOnScreen()
  }
}
