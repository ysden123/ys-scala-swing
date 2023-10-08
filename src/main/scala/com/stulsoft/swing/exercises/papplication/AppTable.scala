/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.papplication

import javax.swing.ListSelectionModel
import javax.swing.table.DefaultTableModel
import scala.swing.*
import scala.swing.event.TableRowsSelected

class AppTable(mainFrame: MainFrame) extends Dialog(mainFrame):
  private val tableFrame = this
  modal = true
  private val model = new DefaultTableModel() {
    override def isCellEditable(row: Int, column: Int): Boolean = false
  }

  model.addColumn("Name")
  model.addColumn("Column 2")
  model.addColumn("Column 3")

  for (rowId <- 0 until 3)
    model.addRow(Array[Any]("name " + rowId, 100 + rowId, 1.3 * rowId))

  private val table = new Table(model)
  table.peer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)

  listenTo(table.selection)
  reactions += {
    case TableRowsSelected(_,_,false) =>
      val selectedRow=table.selection.rows.leadIndex
      val editDialog = new RowEditDialog(tableFrame, model.getValueAt(selectedRow,0).toString)
      editDialog.open()
      editDialog.result.foreach(newName => model.setValueAt(newName, selectedRow, 0))
  }

  private val scrollPanel = new ScrollPane(table)

  contents = scrollPanel

  centerOnScreen()

end AppTable

