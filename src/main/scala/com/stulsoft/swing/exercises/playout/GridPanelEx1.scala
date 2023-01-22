/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.playout

import javax.swing.plaf.basic.BasicBorders
import scala.collection.mutable
import scala.swing.*
import scala.swing.Component.*
import scala.swing.Swing.{EtchedBorder, TitledBorder, unwrapIcon}

object GridPanelEx1 extends SimpleSwingApplication:

  private lazy val ui1:Panel = new GridPanel(2,1){
    contents ++= Seq(new Button("button1"), new Button("button2"))
    border = TitledBorder(EtchedBorder, "Grid Panel 1")
  }

  private lazy val ui2:Panel = new GridPanel(2,1){
    contents ++= Seq(new Button("button1"), new Button("button2"))
    border = TitledBorder(EtchedBorder, "Grid Panel 2")
  }

  private lazy val uis = Seq(ui1, ui2)
  override def top: Frame = new MainFrame{
    title = "Grid Panel Ex1"
    contents = new GridPanel(uis.size,1){
      contents ++= uis
      border = Swing.EmptyBorder(10, 10, 10, 10)
    }

    size = new Dimension(400, 600)
    centerOnScreen()
  }

