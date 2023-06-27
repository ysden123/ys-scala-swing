/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.plabel

import java.awt.Color
import javax.swing.SwingUtilities
import scala.concurrent.Future
import scala.swing.{Dimension, Font, Frame, Graphics2D, Label, MainFrame, SimpleSwingApplication}

object LabelEx1 extends SimpleSwingApplication:
  given ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global

  private var label: Label = _

  override def top: Frame = new MainFrame {
    title = "LabelEx1"

    label = new Label("1") {
      opaque = true
      background = Color.GRAY
      foreground = Color.RED
      //      font = font.deriveFont(40.0.toFloat)
      font = font.deriveFont((40.0 * 10).toFloat)

      override def paint(g: Graphics2D): Unit =
        val stringWidth = g.getFontMetrics.stringWidth(text)
        val componentWidth = bounds.width
        // Find out how much the font can grow in width.
        val widthRatio = componentWidth.toFloat / stringWidth.toFloat

        val newFontSize = (font.getSize * widthRatio).toInt
        val componentHeight = bounds.height

        // Pick a new font size so it will not be larger than the height of label.
        val fontSizeToUse = Math.min(newFontSize, componentHeight)

        // Set the label's font size to the newly determined size.
        font = font.deriveFont(fontSizeToUse.toFloat)

        super.paint(g)
      end paint
    }

    contents = label
    size = new Dimension(400, 600)
    centerOnScreen()

    SwingUtilities.invokeLater(() => {
      Future {
        Thread.sleep(5_000)
        println("White 2 on red")
        label.background = Color.RED
        label.foreground = Color.WHITE
        label.text = "2"
      }

      Future {
        Thread.sleep(10_000)
        println("Black 3 on blue")
        label.background = Color.BLUE
        label.foreground = Color.BLACK
        label.text = "3"
      }

      Future {
        Thread.sleep(15_000)
        println("Black empty on white")
        label.background = Color.WHITE
        label.foreground = Color.BLACK
        label.text = ""
      }
    })
  }