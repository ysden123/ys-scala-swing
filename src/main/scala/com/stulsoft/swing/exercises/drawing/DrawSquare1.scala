/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.drawing

import scala.swing.*
import java.awt.Color
import scala.concurrent.Future
import scala.swing.{Color, *}

object Timer {
  def apply(interval: Int, repeats: Boolean = true)(op: => Unit): Unit = {
    val timeOut = new javax.swing.AbstractAction() {
      def actionPerformed(e : java.awt.event.ActionEvent): Unit = op
    }
    val t = new javax.swing.Timer(interval, timeOut)
    t.setRepeats(repeats)
    t.start()
  }
}
object DrawSquare1 extends SimpleSwingApplication:
  given ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global
  override def top: Frame = new MainFrame {
    var count = 0
    title = "Drawing a square"
    contents = new Panel() {
      override protected def paintComponent(g: Graphics2D): Unit = {
        println("P 001")
        g.setColor(Color.RED)
//        g.clearRect(10, 10, 10, 10)
        g.fillRect(10, 10, 10, 10)
        if count> 1 then
          g.setColor(Color.GREEN)
          g.fillRect(20, 20, 10, 10)

        count += 1
      }
    }
/*
    Future{
      Thread.sleep(15_000)
      contents.foreach( c => c.revalidate())
    }
*/

    size = new Dimension(400, 600)
    centerOnScreen()

    Timer(10_000) {
      println("P 002")
      tick()
    }

    def tick(): Unit = {
      contents.foreach(c => c.repaint())
      // this method is called every 100 milliseconds
    }
  }
end DrawSquare1

