/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.examples

import scala.swing.*
import scala.swing.event.*

object PopupDemo extends SimpleSwingApplication:
  override def top: Frame = new MainFrame {
    def defineAction(reactions: Reactions): Unit =
      reactions += {
        case ButtonClicked(b) =>
          println(s"Pressed ${b.text}")
      }

    val popupMenu: PopupMenu = new PopupMenu {
      contents += new Menu("menu 1") {
        contents += new RadioMenuItem("radio 1.1") {
          defineAction(reactions)
        }
        contents += new RadioMenuItem("radio 1.2") {
          defineAction(reactions)
        }
      }
      contents += new Menu("menu 2") {
        contents += new RadioMenuItem("radio 2.1") {
          defineAction(reactions)
        }
        contents += new RadioMenuItem("radio 2.2") {
          defineAction(reactions)
        }
      }
    }
    val button = new Button("Show Popup Menu")
    reactions += {
      case ButtonClicked(b) => popupMenu.show(b, 0, b.bounds.height)
      case PopupMenuCanceled(m) => println("Menu " + m + " canceled.")
    }
    listenTo(popupMenu)
    listenTo(button)

    contents = new FlowPanel(button)

    size = new Dimension(400, 600)
    centerOnScreen()
  }

