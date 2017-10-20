package com.seanshubin.documentation.domain.diagram

trait Element {
  def renderSvg(): Seq[String]

  def move(dx: Int, dy: Int): Element
}
