/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.pimages

import java.io.File
import javax.swing.filechooser.FileFilter
import scala.swing.*
import scala.swing.FileChooser.Result.Approve

object ImageViewer extends SimpleSwingApplication:
  override def top: Frame = new MainFrame {
    title = "Image Viewer"
    val imagePanel = new ImagePanel

    menuBar = new MenuBar {
      contents += new Menu("File") {
        contents += new MenuItem(Action("Open") {
          val fileChooser = new FileChooser()
          fileChooser.fileFilter = new FileFilter {
            override def accept(f: File): Boolean = {
              if f.isFile then
                val extension = f.getPath.toUpperCase()
                extension.endsWith(".JPG")
                  || extension.endsWith(".PNG")
                  || extension.endsWith(".TIF")
              else
                true
            }

            override def getDescription: String = "Image files (.jpg,.png,.tif)"
          }
          val choice = fileChooser.showOpenDialog(menuBar)
          if choice == Approve then
            val file = fileChooser.selectedFile
            imagePanel.imagePath = file.getAbsolutePath
            imagePanel.repaint()
        })
      }
    }

    contents = imagePanel

    size = new Dimension(600, 500)
    centerOnScreen()
  }
end ImageViewer

