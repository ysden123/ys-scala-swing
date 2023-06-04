/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.pinput

import java.awt.{Color, Graphics2D, Point, geom}
import scala.swing.Swing._
import scala.swing.event._
import scala.swing.{Frame, MainFrame, Panel, SimpleSwingApplication}
object InputEventEx01 extends SimpleSwingApplication:
  lazy val ui:Panel = new Panel {
    background = Color.white
    preferredSize = (300, 200)

    focusable = true
    listenTo(mouse.clicks, mouse.moves, keys)

    reactions += {
      case e:MousePressed =>
        println(s"Event: MousePressed, point(${e.point.x},${e.point.y})")
        println(s"button=${e.peer.getButton}") // 1 - left, 2 - middle, 3 - right
        println(s"isShiftDown: ${e.peer.isShiftDown}, isControlDown: ${e.peer.isControlDown}")
        requestFocusInWindow()
      case _: FocusLost => repaint()
    }
  }

  override def top: Frame = new MainFrame{
    title =  "Input Events"

    contents = ui
  }
