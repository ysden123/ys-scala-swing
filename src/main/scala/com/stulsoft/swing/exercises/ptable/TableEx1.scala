/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.ptable

import scala.swing.{Frame, MainFrame, SimpleSwingApplication, Table}

import scala.swing._
import scala.swing.event.TableRowsSelected

object TableEx1 extends SimpleSwingApplication:
  def top: Frame = new MainFrame {
    title = "Table Example"

    // Sample data for the table
    val rowData = Array(
      Array("John", "Doe", 30),
      Array("Jane", "Smith", 25),
      Array("Bob", "Johnson", 40)
    )

    // Define column names
    val columnNames = Seq("First Name", "Last Name", "Age")

    // Create a Table component with data and column names
    val tableModel = new javax.swing.table.DefaultTableModel(rowData, columnNames.toArray)
    val table = new Table(rowData, columnNames) {
      model = tableModel
      selection.intervalMode = Table.IntervalMode.Single
    }

    // Define a selection listener for the table
    listenTo(table.selection)
    reactions += {
      case TableRowsSelected(_, _, false) =>
        val selectedRow = table.selection.rows.leadIndex
        if (selectedRow >= 0) {
          val firstName = tableModel.getValueAt(selectedRow, 0).toString
          val lastName = tableModel.getValueAt(selectedRow, 1).toString
          val age = tableModel.getValueAt(selectedRow, 2).toString.toInt
          println(s"Selected: $firstName $lastName (Age: $age)")
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
