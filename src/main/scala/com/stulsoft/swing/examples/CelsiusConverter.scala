/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.examples

import scala.swing.*
import scala.swing.event.*

object CelsiusConverter extends SimpleSwingApplication:
  override def top: Frame = new MainFrame {
    title = "Convert Celsius to Fahrenheit"
    val tempCelsius = new TextField
    val celsiusLabel: Label = new Label {
      text = "Celsius"
      border = Swing.EmptyBorder(5, 5, 5, 5)
    }

    val convertButton: Button = new Button {
      text = "Convert"
            border = Swing.EmptyBorder(5,5,5,5)
    }

    val fahrenheitLabel: Label = new Label {
      text = "Fahrenheit      "
      border = Swing.EmptyBorder(5, 5, 5, 5)
      listenTo(convertButton, tempCelsius)

      def convert(): Unit = {
        val c = Integer.parseInt(tempCelsius.text)
        val f = c * 9 / 5 + 32
        text = "<html><font color = red>" + f + "</font> Fahrenheit</html>"
      }

      reactions += {
        case ButtonClicked(_) | EditDone(_) => convert()
      }
    }

    contents = new GridPanel(2, 2) {
      contents ++= Seq(tempCelsius, celsiusLabel, convertButton, fahrenheitLabel)
      border = Swing.EmptyBorder(10, 10, 10, 10)
    }

    centerOnScreen()
  }