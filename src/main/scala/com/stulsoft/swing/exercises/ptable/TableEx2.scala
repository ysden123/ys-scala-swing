/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.ptable

import javax.swing.table.DefaultTableModel
import scala.swing.event.TableRowsSelected
import scala.swing.*
import scala.util.Random

object TableEx2 extends SimpleSwingApplication:
  def top: Frame = new MainFrame {
    title = "Table Ex2"
    val model:DefaultTableModel = new DefaultTableModel()
    val table = new Table(model)
    model.addColumn("c1")
    model.addColumn("c2")
    model.addColumn("c3")

    model.addRow(Array[Any]("name1", 12.0, 3))
    model.addRow(Array[Any]("name2", 33.0, 7))

    // Define a selection listener for the table
    listenTo(table.selection)
    reactions += {
      case TableRowsSelected(_, _, false) =>
        model.addRow(Array[Any]("name " + Random.nextInt(), Random.nextDouble, Random.nextInt()))
    }


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
