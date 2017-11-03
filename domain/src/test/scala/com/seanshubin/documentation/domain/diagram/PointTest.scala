package com.seanshubin.documentation.domain.diagram

import org.scalatest.FunSuite

class PointTest extends FunSuite {
  test("rotate") {
    val point = Point(100, 100)
    for {
      eightPart <- 0 to 8
      newPoint = point.rotate(Fraction(eightPart, 8))
      radius = newPoint.radius
      turns = newPoint.turns
    } {
      println(s"$radius, $turns, $newPoint")
    }
    assert(point.rotate(Fraction(1, 4)) === Point(-100, 100))
    assert(point.rotate(Fraction(-1, 4)) === Point(100, -100))
    assert(point.rotate(Fraction(3, 4)) === Point(100, -100))
    assert(point.rotate(Fraction(1, 2)) === Point(-100, -100))
  }
}
