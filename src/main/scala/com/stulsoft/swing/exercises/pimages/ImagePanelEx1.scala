/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.pimages

import javax.swing.ImageIcon
import scala.swing.*
import scala.swing.Component.*

/**
 * Using the ImageIcon.
 * No support for DNG, tif
 */
object ImagePanelEx1 extends SimpleSwingApplication:
  override def top: Frame = new MainFrame {
    title = "Label as image icon"
    contents = new Label {
      try
        icon = new ImageIcon("c:/work/2002 05 13 322.jpg")
      catch
        case exception: Exception =>
          println(exception.getMessage)
    }

    size = new Dimension(400, 600)
    centerOnScreen()
  }

