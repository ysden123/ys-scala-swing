/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.panels

import java.awt.Color
import scala.swing.*
import TabbedPane.*

object BoxLayoutPanels extends SimpleSwingApplication:
  private def buildComponents():Seq[Component]=
    val l = new Label("panel label")

    val b = new Button("button1")
    val b1 = new Button("button2")
    val b2 = new Button("button3")
    val b3 = new Button("button4")
    Seq(b, b1, b2, b3, l)

  private lazy val tabs = new TabbedPane{
    pages += new Page("Vertical", new BoxPanel(Orientation.Vertical){
      contents ++= buildComponents()
      background = Color.red
    })

    pages += new Page("Horizontal", new BoxPanel(Orientation.Horizontal){
      contents ++= buildComponents()
      background = Color.red
    })

    pages += new Page("NoOrientation", new BoxPanel(Orientation.NoOrientation){
      contents ++= buildComponents()
      background = Color.red
    })
  }
  override def top: Frame = new MainFrame{
    title = "Box Layout Panels"
    contents = tabs
    size = new Dimension(400, 600)
    centerOnScreen()
  }