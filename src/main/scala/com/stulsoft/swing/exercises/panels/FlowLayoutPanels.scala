/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.panels

import java.awt.Color
import scala.swing.*
import scala.swing.Component.*
import TabbedPane.*

object FlowLayoutPanels extends SimpleSwingApplication:
  private def l: Component = new Label("panel label")

  private def b: Component = new Button("button1")

  private def b1: Component = new Button("button2")

  private def b2: Component = new Button("button3")

  private def b3: Component = new Button("button4")

  private def buildComponents(): Array[Component] =
    Array(b, b1, b2, b3, l)

  private lazy val tabs = new TabbedPane {
    pages += new Page("Center",
      new FlowPanel(FlowPanel.Alignment.Center)(buildComponents(): _*) {
        background = Color.red
      }
    )

    pages += new Page("Left",
      new FlowPanel(FlowPanel.Alignment.Left)(buildComponents(): _*) {
        background = Color.red
      }
    )

    pages += new Page("Right",
      new FlowPanel(FlowPanel.Alignment.Right)(buildComponents(): _*) {
        background = Color.red
      }
    )

    pages += new Page("Trailing",
      new FlowPanel(FlowPanel.Alignment.Trailing)(buildComponents(): _*) {
        background = Color.red
      }
    )

    pages += new Page("Leading",
      new FlowPanel(FlowPanel.Alignment.Leading)(buildComponents(): _*) {
        background = Color.red
      }
    )
  }

  override def top: Frame = new MainFrame {
    title = "Flow Layout Panels"
    contents = tabs
    size = new Dimension(400, 600)
    centerOnScreen()
  }
