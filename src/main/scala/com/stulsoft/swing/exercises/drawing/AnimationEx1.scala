/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.drawing

import java.awt.Color
import scala.swing.{Dimension, Frame, Graphics2D, MainFrame, Panel, SimpleSwingApplication}

object AnimationEx1 extends SimpleSwingApplication:
  object Timer {
    def apply(interval: Int, repeats: Boolean = true)(op: => Unit): Unit = {
      val timeOut = new javax.swing.AbstractAction() {
        def actionPerformed(e: java.awt.event.ActionEvent): Unit = op
      }
      val t = new javax.swing.Timer(interval, timeOut)
      t.setRepeats(repeats)
      t.start()
    }
  }

  override def top: Frame = new MainFrame {
    title = "Animation ex 1"
    contents = new Panel {
      override protected def paintComponent(g: Graphics2D): Unit = {
        draw(g)
      }
    }
    size = new Dimension(400, 600)
    centerOnScreen()

    Timer(750) {
      tick()
    }

    def tick(): Unit = {
      contents.foreach(c => c.repaint())
    }
  }

  private var iteration = 0

  private def draw(g: Graphics2D): Unit = {
    if iteration > 1 then
      g.setColor(Color.RED)
      //      g.fillRect(10, 10, 10, 10)
      g.clearRect(0, 0, 400, 600)
      g.fillRect(10 + iteration * 2, 10 + iteration * 2, 10, 10)

    iteration += 1
  }
end AnimationEx1


