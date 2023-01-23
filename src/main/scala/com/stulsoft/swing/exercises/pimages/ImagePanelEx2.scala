/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.pimages

import java.awt.image.BufferedImage
import java.io.File
import javax.swing.ImageIcon
import scala.swing.*
import scala.swing.Component.*
import javax.imageio.ImageIO

/**
 * Using the ImageIcon.
 * No support for DNG
 */
object ImagePanelEx2 extends SimpleSwingApplication:
  override def top: Frame = new MainFrame {
    title = "Image panel demo"

    contents = new ImagePanel {
      imagePath = "c:/work/2023 01 19 009-Edit.tif"
//      imagePath = "c:/work/2002 05 13 322.jpg"
    }

    size = new Dimension(400, 600)
    centerOnScreen()
  }
end ImagePanelEx2

class ImagePanel extends Panel:
  private var _imagePath = ""
  private var bufferedImage: BufferedImage = _

  def imagePath: String = _imagePath

  def imagePath_=(value: String): Unit =
    _imagePath = value
    bufferedImage = ImageIO.read(new File(_imagePath))

  override def paintComponent(g: Graphics2D): Unit =
    if null != bufferedImage then
      val ratio = bufferedImage.getWidth.toFloat / bufferedImage.getHeight.toFloat

      var showWidth = size.width
      var showHeight = (showWidth / ratio).toInt

      if showHeight > size.getHeight then
        showHeight = size.getHeight.toInt
        showWidth = (showHeight * ratio).toInt

      g.drawImage(bufferedImage, 0, 0, showWidth, showHeight, null)
end ImagePanel

