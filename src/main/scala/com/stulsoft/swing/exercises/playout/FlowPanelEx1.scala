/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.playout

import javax.swing.plaf.basic.BasicBorders
import scala.collection.mutable
import scala.swing.*
import scala.swing.Component.*
import scala.swing.Swing.{EtchedBorder, TitledBorder, unwrapIcon}

object FlowPanelEx1 extends SimpleSwingApplication:
  private lazy val ui1: Panel = new FlowPanel(FlowPanel.Alignment.Center)(new Button("Button 1"), new Button("Button 2")) {
    border = TitledBorder(EtchedBorder, "FlowPanel.Alignment.Center")
  }

  private lazy val ui2: Panel = new FlowPanel(FlowPanel.Alignment.Left)(new Button("Button 1"), new Button("Button 2")) {
    border = TitledBorder(EtchedBorder, "FlowPanel.Alignment.Left")
  }

  private lazy val ui3: Panel = new FlowPanel(FlowPanel.Alignment.Leading)(new Button("Button 1"), new Button("Button 2")) {
    border = TitledBorder(EtchedBorder, "FlowPanel.Alignment.Leading")
  }

  private lazy val ui4: Panel = new FlowPanel(FlowPanel.Alignment.Trailing)(new Button("Button 1"), new Button("Button 2")) {
    border = TitledBorder(EtchedBorder, "FlowPanel.Alignment.Trailing")
  }

  private lazy val ui5: Panel = new FlowPanel(FlowPanel.Alignment.Right)(new Button("Button 1"), new Button("Button 2")) {
    border = TitledBorder(EtchedBorder, "FlowPanel.Alignment.Right")
  }

  private lazy val uis = Seq(ui1, ui2, ui3, ui4, ui5)

  override def top: Frame = new MainFrame {
    title = "Flow Panel Ex1"
    //    contents = ui

    contents = new GridPanel(uis.size, 1) {
      contents ++= uis
      border = Swing.EmptyBorder(10, 10, 10, 10)
    }
    size = new Dimension(400, 600)
    centerOnScreen()
  }


