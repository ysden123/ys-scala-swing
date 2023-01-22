/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.examples

import java.awt.Color
import java.text.SimpleDateFormat
import java.util.Date
import javax.swing.{Icon, ImageIcon}
import scala.swing.*
import scala.swing.event.*

object ComboBoxes extends SimpleSwingApplication:

  import ComboBox.*

  lazy val ui: FlowPanel = new FlowPanel {
    contents += new ComboBox(List(1, 2, 3, 4)) // This combo box is not editable

    private val patterns = List(
      "dd MMMMM yyyy",
      "dd.MM.yy",
      "MM/dd/yy",
      "yyyy.MM.dd G 'at' hh:mm:ss z",
      "EEE, MMM d, ''yy",
      "h:mm a",
      "H:mm:ss:SSS",
      "K:mm a,z",
      "yyyy.MMMMM.dd GGG hh:mm aaa"
    )

    private val dateBox = new ComboBox(patterns) { // This combo box is editable
      makeEditable()
    }
    contents += dateBox

    private val field = new TextField(20) {
      editable = false
    }
    contents += field

    reactions += {
      case SelectionChanged(`dateBox`) => reformat() // Same: case SelectionChanged(dateBox) => reformat()
      case SelectionChanged(field) =>
    }

    listenTo(dateBox.selection)

    def reformat(): Unit =
      try
        val formatter = new SimpleDateFormat(dateBox.selection.item)
        val dateString = formatter.format(new Date)
        field.foreground = Color.black
        field.text = dateString
      catch
        case exception: IllegalArgumentException =>
          field.foreground = Color.red
          field.text = "Error: " + exception.getMessage

    private val icons = try
      List(
        new ImageIcon(resourceFromClassloader("images/margarita1.jpg")),
        new ImageIcon(resourceFromClassloader("images/margarita2.jpg")),
        new ImageIcon(resourceFromClassloader("images/rose.jpg")),
        new ImageIcon(resourceFromClassloader("images/banana.jpg"))
      )
    catch
      case _: Exception =>
        println("Couldn't load images for combo box")
        List(Swing.EmptyIcon)

    private val iconBox = new ComboBox(icons) {
      renderer = new ListView.AbstractRenderer[Icon, Label](new Label) {
        override def configure(list: ListView[_], isSelected: Boolean, focused: Boolean, icon: Icon, index: Int): Unit =
          component.icon = icon
          component.xAlignment = Alignment.Center
          if isSelected then
            component.border = Swing.LineBorder(list.selectionBackground, 3)
          else
            component.border = Swing.EmptyBorder(3)
      }
    }

    contents += iconBox
  }

  override def top: Frame = new MainFrame {
    title = "ComboBoxes Demo"
    contents = ui
  }

