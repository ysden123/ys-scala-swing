/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.resizing
import scala.swing.*

object ResizablePanel2 extends SimpleSwingApplication:
  override def top: Frame = new MainFrame{
    title = "Resizable Panel Example 2"

    contents = new BorderPanel{
      layout(new Label("The label (north)")) = BorderPanel.Position.North

      layout(new TextArea(){
        border = Swing.TitledBorder(Swing.EtchedBorder, "Result")
      }) = BorderPanel.Position.Center

      border = Swing.EmptyBorder(30,30,10,30)
    }
  }


