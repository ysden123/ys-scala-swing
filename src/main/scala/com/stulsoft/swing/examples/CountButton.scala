/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.examples
import scala.swing.*
import scala.swing.event.*

object CountButton extends SimpleSwingApplication:
  override def top: Frame = new MainFrame{
    title = "My Frame"
    contents = new GridPanel(2,2){
      hGap = 3
      vGap = 3

      private val button = new Button{
        text = "Press me!"
      }
      contents += button

      private val label = new Label{
        text = "No button clicks registered"
      }
      contents += label

      listenTo(button)

      private var nClicks=0

      reactions += {
        case ButtonClicked(_) =>
          nClicks += 1
          label.text = "Number of button clicks: " + nClicks
      }
    }
  }
