package com.seanshubin.documentation.domain.diagram

case class Box(x: Int, y: Int, text: String) extends Element {
  def topLine: Line = Line(Point(left, top), Point(right, top))

  def bottomLine: Line = Line(Point(left, bottom), Point(right, bottom))

  def left: Int = x

  def top: Int = y

  def bottom: Int = y + height

  def right: Int = x + width

  def height: Int = 70

  def width: Int = baseWidth + charWidth * text.length

  def baseWidth: Int = 40

  def charWidth: Int = 11

  override def renderSvg(): Seq[String] = {
    val textX = x + 20
    val textY = y + 40
    val renderedRect = s"""<rect x="$x" y="$y" rx="20" ry="20" width="$width" height="$height" fill="none" stroke="black" stroke-width="3"/>"""
    val renderedText = s"""<text x="$textX" y="$textY" fill="blue" font-family="Consolas" font-size="20" font-weight="bold">$text</text>"""
    Seq(renderedRect, renderedText)
  }

  override def move(dx: Int, dy: Int): Element = {
    Box(x + dx, y + dy, text)
  }
}
