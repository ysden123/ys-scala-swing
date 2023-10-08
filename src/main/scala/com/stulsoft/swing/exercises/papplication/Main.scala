/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.papplication

import scala.swing.{Action, Dimension, Frame, MainFrame, Menu, MenuBar, MenuItem, SimpleSwingApplication}

object Main extends SimpleSwingApplication:
  override def top: Frame = new MainFrame:
    private val theMainFrame: MainFrame = this
    title = "Main frame"

    menuBar = new MenuBar {
      contents += new Menu("File") {
        contents += new MenuItem(Action("Table") {
          new AppTable(theMainFrame).open()
/*
          new Frame {
            title = "Table"
            contents = AppTable(theMainFrame)
            size = new Dimension(600, 400)
            centerOnScreen()
          }.open()
*/
        })
        contents += new MenuItem(Action("Exit") {
          theMainFrame.close()
          theMainFrame.dispose()
        })
      }
    }

    size = new Dimension(600, 600)
    centerOnScreen()
  end top

end Main

