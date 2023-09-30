/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.ptable

import scala.swing.{Frame, MainFrame, SimpleSwingApplication, Table}

import scala.swing._
import scala.swing.event.TableRowsSelected

object TableEx1 extends SimpleSwingApplication:
  def top: Frame = new MainFrame {
    title = "Table Ex1"

    // Sample data for the table
    val rowData:Array[Array[Any]] = Array.ofDim[Any](2,3)
    rowData(0)(0) = "name1"
    rowData(0)(1) = 765
    rowData(0)(2) = 98.0
    rowData(1)(0) = "name2"
    rowData(1)(1) = 77
    rowData(1)(2) = 55.0
    val table = new Table(rowData, List("c1", "c2", "c3"))

    // Define a selection listener for the table
    listenTo(table.selection)
    reactions += {
      case TableRowsSelected(_, _, false) =>
        val selectedRow = table.selection.rows.leadIndex
        if (selectedRow >= 0) {
          println(s"Selected: $selectedRow")
          if selectedRow < rowData.length then
            rowData(selectedRow)(0)="Changed"
            table.repaint()
        }
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
