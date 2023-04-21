/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.drawing


import java.awt.Color
import scala.swing.{Color, *}

object DrawSquare1 extends SimpleSwingApplication:
  override def top: Frame = new MainFrame {
    title = "Drawing a square"
    contents = new Panel() {
      override protected def paintComponent(g: Graphics2D): Unit = {
        g.setColor(Color.RED)
//        g.clearRect(10, 10, 10, 10)
        g.fillRect(10, 10, 10, 10)
        g.fillRect(20, 20, 10, 10)
      }
    }

    size = new Dimension(400, 600)
    centerOnScreen()
  }
end DrawSquare1

