/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.ptable

import com.stulsoft.swing.examples.ComboBoxes.resourceFromClassloader

import javax.swing.ImageIcon
import javax.swing.table.DefaultTableModel
import scala.swing.*

/**
 * Demonstrates how to show an icon in a table cell.
 */
object TableEx3 extends SimpleSwingApplication:
  def top: Frame = new MainFrame {
    title = "Table Ex3"
    val model: DefaultTableModel = new DefaultTableModel()
    val table = new Table(model)
    table.rowHeight = 30
    model.addColumn("c1")
    model.addColumn("c2")
    model.addColumn("c3")

    private val imageIcon1 = loadImageIcon("images/clear-day.png", table)
    private val imageIcon2 = loadImageIcon("images/partly-cloud.png", table)

    model.addRow(Array[Any]("clear-day", 12.0, imageIcon1))
    model.addRow(Array[Any]("partly-cloud", 25.3, imageIcon2))

    // Create a scroll pane to display the table if there are many rows
    val scrollPane = new ScrollPane(table)

    // Add the scroll pane to the frame
    contents = new BoxPanel(Orientation.Vertical) {
      contents += scrollPane
      border = Swing.EmptyBorder(10, 10, 10, 10)
    }

    // Set the size of the frame and make it visible
    size = new Dimension(400, 300)
    centerOnScreen()
  }

  private def loadImageIcon(path:String, table:Table):ImageIcon=
    val imageIcon = new ImageIcon(resourceFromClassloader(path))
    val maxHeight=table.rowHeight - 3
    new ImageIcon(imageIcon.getImage.getScaledInstance(maxHeight, maxHeight, java.awt.Image.SCALE_SMOOTH))

end TableEx3

