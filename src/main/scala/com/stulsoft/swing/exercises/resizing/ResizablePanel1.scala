/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.resizing

import scala.swing.*
object ResizablePanel1 extends SimpleSwingApplication:
  def top: MainFrame = new MainFrame {
    title = "Resizable Panel Example 1"
    contents = new BorderPanel {
      layout(new Label("North")) = BorderPanel.Position.North
      layout(new Label("South")) = BorderPanel.Position.South
      layout(new Label("East")) = BorderPanel.Position.East
      layout(new Label("West")) = BorderPanel.Position.West
      layout(new Label("Center")) = BorderPanel.Position.Center
      border = Swing.EmptyBorder(30, 30, 10, 30)
    }
  }