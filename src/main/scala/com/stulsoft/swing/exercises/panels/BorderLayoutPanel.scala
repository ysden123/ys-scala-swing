/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.panels

import java.awt.Color
import scala.swing.*
import scala.swing.BorderPanel.Position
import scala.swing.Component.*

object BorderLayoutPanel extends SimpleSwingApplication:
  override def top: Frame = new MainFrame {
    title = "Border layout panel"
    val l = new Label("panel label (Center)")

    val b = new Button("North")
    val b1 = new Button("South")
    val b2 = new Button("East")
    val b3 = new Button("West")

    contents = new BorderPanel {
      layout(b) = Position.North
      layout(b1) = Position.South
      layout(b2) = Position.East
      layout(b3) = Position.West
      layout(l) = Position.Center
      background = Color.red
    }

    size = new Dimension(400, 600)
    centerOnScreen()
  }


