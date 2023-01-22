/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.examples

import scala.swing.*

object ListViewDemo extends SimpleSwingApplication:
  override def top: Frame = new MainFrame {

    case class City(name: String, country: String, population: Int, capital: Boolean)

    val items: List[City] = List(
      City(name = "Lausanne", country = "Switzerland", population = 129273, capital = false),
      City(name = "Paris", country = "France", population = 2203817, capital = true),
      City(name = "New York", country = "USA", population = 8363710, capital = false),
      City(name = "Berlin", country = "Germany", population = 3416300, capital = true),
      City(name = "Tokyo", country = "Japan", population = 12787981, capital = true)
    )

    import ListView._

    contents = new FlowPanel(new ScrollPane(new ListView[City](items) {
      renderer = Renderer(item => s"${item.name} ${item.country}")
    }))

    size = new Dimension(400, 600)
    centerOnScreen()
  }

