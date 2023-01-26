/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.panels

import scala.swing.*
import scala.swing.Component.*
import scala.swing.Swing.{EtchedBorder, TitledBorder, unwrapIcon}

object ChangePanels extends SimpleSwingApplication:

  override def top: Frame = new MainFrame {
    title = "Change panels"

    val panel1: FlowPanel = new FlowPanel(FlowPanel.Alignment.Center)(new Button("Button 1")) {
      border = TitledBorder(EtchedBorder, "Panel 1")
      visible = false
    }

    val panel2: FlowPanel = new FlowPanel(FlowPanel.Alignment.Center)(new Button("Button 2"), new TextField(10)) {
      border = TitledBorder(EtchedBorder, "Panel 2")
      visible = false
    }

    val panels: Array[Panel] = Array(panel1, panel2)

    def activatePanel(activePanel: Panel): Unit =
      panels.foreach(thePanel => thePanel.visible = thePanel == activePanel)

    contents = new FlowPanel(FlowPanel.Alignment.Center)(panels: _*)

    menuBar = new MenuBar {
      contents += new Menu("Actions") {
        contents += new MenuItem(Action("Panel 1") {
          activatePanel(panel1)
        })

        contents += new MenuItem(Action("Panel 2") {
          activatePanel(panel2)
        })

        contents += new MenuItem(Action("Hide all") {
          panels.filter(panel => panel.visible).foreach(panel => panel.visible = false)
        })

        contents += new MenuItem(Action("Close") {
          dispose()
        })
      }
    }

    size = new Dimension(600, 500)
    centerOnScreen()
  }

