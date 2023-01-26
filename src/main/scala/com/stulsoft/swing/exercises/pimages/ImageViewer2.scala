/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.pimages

import java.io.File
import javax.swing.filechooser.FileFilter
import scala.swing.*
import scala.swing.FileChooser.Result.Approve

object ImageViewer2 extends SimpleSwingApplication:
  private var lastDir:File = _
  private def openFile(imagePanel: ImagePanel): Unit =
    val fileChooser = new FileChooser(lastDir)

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
    val choice = fileChooser.showOpenDialog(null)
    if choice == Approve then
      val file = fileChooser.selectedFile
      lastDir = file.getParentFile
      imagePanel.imagePath = file.getAbsolutePath
      imagePanel.repaint()
  end openFile


  override def top: Frame = new MainFrame {
    title = "Image Viewer"
    val imagePanel = new ImagePanel

    menuBar = new MenuBar {
      contents += new Menu("File") {
        contents += new MenuItem(Action("Open") {
          openFile(imagePanel)
        })
      }
    }

    contents = imagePanel

    size = new Dimension(600, 500)
    centerOnScreen()
  }
end ImageViewer2

