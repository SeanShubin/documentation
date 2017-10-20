package com.seanshubin.documentation.domain.diagram

case class Line(origin: Point, destination: Point) {
  def fraction(numerator: Int, denominator: Int): Point = {
    val x = (destination.x - origin.x) * numerator / denominator + origin.x
    val y = (destination.y - origin.y) * numerator / denominator + origin.y
    Point(x, y)
  }

  def truncateToSizeFromOrigin(size: Int): Line = {
    this
  }

  def rotate(reference: Point, numerator: Int, denominator: Int): Line = {
    this
  }

  def renderSvg(): Seq[String] = {
    val rendered = s"""<line x1="${origin.x}" y1="${origin.y}" x2="${destination.x}" y2="${destination.y}" fill="none" stroke="black" stroke-width="3" />"""
    Seq(rendered)
  }
}
