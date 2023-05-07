/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.pstatus

import javax.swing.SwingUtilities
import scala.swing.BorderPanel.Position
import scala.swing.event.{MouseClicked, MousePressed}
import scala.swing.{BorderPanel, Dimension, Frame, Label, MainFrame, SimpleSwingApplication}

object StatusEx1 extends SimpleSwingApplication:
  override def top: Frame = new MainFrame {
    title = "Status line"

    val sl = new Label("This is the status line")

    val thePanel: Label = new Label("This is main panel") {
      listenTo(mouse.clicks)

      reactions += {
        case MousePressed(_, p, _, _, _) =>
          sl.text = s"Coordinates: ${p.x} - ${p.y}. sl.bounds.width=${sl.bounds.width}, sl.bounds.height=${sl.bounds.height}"
      }
    }

    contents = new BorderPanel {
      layout(sl) = Position.South
      layout(thePanel) = Position.Center
    }
    size = new Dimension(400, 600)
    centerOnScreen()

  }
    
