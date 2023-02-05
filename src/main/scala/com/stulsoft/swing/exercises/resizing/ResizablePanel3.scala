/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.resizing

import scala.swing.*
import scala.swing.Swing.*
import scala.swing.TabbedPane.Page
import scala.swing.{BorderPanel, Frame, MainFrame, SimpleSwingApplication, Swing}

object ResizablePanel3  extends SimpleSwingApplication{

  private val page1: BorderPanel = new BorderPanel{
    val path = new TextField("Select path", 15)
    val button = new Button("The button")
    val selectPanel = new FlowPanel(FlowPanel.Alignment.Left)(path, button)

    val result: TextArea = new TextArea{
      border = Swing.TitledBorder(EtchedBorder, "Result")
    }

    layout(selectPanel) = BorderPanel.Position.North
    layout(result) = BorderPanel.Position.Center
  }

  private val page2: BorderPanel = new BorderPanel{
    val button = new Button("The button")

    val controlPanel=new FlowPanel(FlowPanel.Alignment.Left)(button)

    val result = new TextArea
    val resultScrollPanel: ScrollPane = new ScrollPane{
      border = Swing.TitledBorder(EtchedBorder, "Result")
      contents = result
    }

    layout(controlPanel) = BorderPanel.Position.North
    layout(resultScrollPanel) = BorderPanel.Position.Center
  }
  val tabs: TabbedPane = new TabbedPane {
    pages += new Page("Page1", page1)
    pages += new Page("Page2", page2)

  }
  override def top: Frame = new MainFrame{
    title = "Resizable Panel Example 3"

    contents = new BorderPanel{
      layout(tabs) = BorderPanel.Position.Center

      border = Swing.EmptyBorder(5,5,5,5)
    }
    size = new Dimension(400,400)
    centerOnScreen()
  }
}
