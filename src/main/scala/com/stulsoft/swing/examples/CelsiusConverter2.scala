/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.examples

import scala.swing.{Alignment, FlowPanel, Frame, Label, MainFrame, SimpleSwingApplication, Swing, TextField}
import scala.swing.event.*

object CelsiusConverter2 extends SimpleSwingApplication:
  private def newField: TextField = new TextField {
    text = "0"
    columns = 5
    horizontalAlignment = Alignment.Right
  }

  private val celsius = newField
  private val fahrenheit = newField

  listenTo(fahrenheit, celsius)

  reactions += {
    case EditDone(`fahrenheit`) =>
      val f = Integer.parseInt(fahrenheit.text)
      val c = (f - 32) * 5 / 9
      celsius.text = c.toString
    case EditDone(`celsius`) =>
      val c = Integer.parseInt(celsius.text)
      val f = c * 9 / 5 + 32
      fahrenheit.text = f.toString
  }

  lazy val ui = new FlowPanel(celsius, new Label(" Celsius = "),
    fahrenheit, new Label(" Fahrenheit")) {
    border = Swing.EmptyBorder(15, 10, 10, 10)
  }

  override def top: Frame = new MainFrame {
    title = "Convert Celsius / Fahrenheit"
    contents = ui
    centerOnScreen()
  }

