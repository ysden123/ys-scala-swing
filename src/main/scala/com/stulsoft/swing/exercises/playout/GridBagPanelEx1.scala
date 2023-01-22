/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.playout

import java.awt.{ComponentOrientation, Insets}
import javax.swing.plaf.basic.BasicBorders
import scala.collection.mutable
import scala.swing.*
import scala.swing.Component.*
import scala.swing.Swing.{EtchedBorder, TitledBorder, unwrapIcon}
import GridBagPanel.*

object GridBagPanelEx1 extends SimpleSwingApplication:
  private lazy val ui1: Panel = new GridBagPanel {
    val c = new Constraints

    c.grid = (1, 1)
    c.anchor = GridBagPanel.Anchor.Center
    layout(new Button("Button 1")) = c

    c.grid = (2, 1)
    c.anchor = Anchor.PageEnd
    c.insets = new Insets(10, 0, 0, 0) //top padding
    layout(new Button("Button 2")) = c

    border = TitledBorder(EtchedBorder, "Grid Bag Panel Fill.Horizontal")
  }

  private lazy val ui2: Panel = new GridBagPanel{
      val c = new Constraints
      c.anchor = GridBagPanel.Anchor.North
      layout(new Button("Button 1")) = c

      c.anchor = GridBagPanel.Anchor.East
      layout(new Button("Button 2")) = c

      border = TitledBorder(EtchedBorder, "Grid Bag Panel Fill.Vert")
    }

  private lazy val uis = Seq(ui1, ui2)

  override def top: Frame = new MainFrame {
    title = "Grid Bag Panel Ex1"
    contents = new GridPanel(uis.size, 1) {
      contents ++= uis
      border = Swing.EmptyBorder(10, 10, 10, 10)
    }

    size = new Dimension(400, 600)
    centerOnScreen()
  }