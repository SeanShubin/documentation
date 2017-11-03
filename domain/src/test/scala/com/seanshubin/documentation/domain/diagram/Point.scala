package com.seanshubin.documentation.domain.diagram

case class Point(x: Int, y: Int) {
  def move(dx: Int, dy: Int): Point = {
    Point(x + dx, y + dy)
  }

  def radius: Double = {
    Math.sqrt(x * x + y * y)
  }

  def turns: Double = {
    Point.radiansToTurns(Math.atan2(y, x))
  }

  def rotate(turnsToRotate: Fraction): Point = {
    val newTurns = turns + turnsToRotate.toDouble
    Point.fromRadiusAndTurns(radius, newTurns)
  }
}

object Point {
  val RadiansPerTurn = 2 * Math.PI

  def fromRadiusAndTurns(radius: Double, turns: Double): Point = {
    val x = radius * Math.cos(turnsToRadians(turns))
    val y = radius * Math.sin(turnsToRadians(turns))
    Point(roundToInt(x), roundToInt(y))
  }

  def turnsToRadians(turns: Double): Double = {
    turns * RadiansPerTurn
  }

  def radiansToTurns(radians: Double): Double = {
    radians / RadiansPerTurn
  }

  def roundToInt(x: Double): Int = {
    Math.floor(x + 0.5).toInt
  }
}