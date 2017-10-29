package com.seanshubin.documentation.domain.diagram

case class Point(x: Int, y: Int) {
  def move(dx: Int, dy: Int): Point = {
    Point(x + dx, y + dy)
  }
}
