package com.seanshubin.documentation.domain.diagram

case class Arrow(origin: Point, destination: Point) extends Element {
  override def renderSvg(): Seq[String] = {
    val line = Line(origin, destination)
    val arrowHeadPart = line.truncateToSizeFromOrigin(5)
    val arrowHeadLeft = arrowHeadPart.rotate(line.destination, 1, 20)
    val arrowHeadRight = arrowHeadPart.rotate(line.destination, -1, 20)
    val elements = Seq(line, arrowHeadLeft, arrowHeadRight)
    elements.flatMap(_.renderSvg)
  }

  override def move(dx: Int, dy: Int) = {
    Arrow(origin.move(dx, dy), destination.move(dx, dy))
  }
}
