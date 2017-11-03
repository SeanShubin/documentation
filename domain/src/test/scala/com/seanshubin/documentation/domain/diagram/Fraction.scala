package com.seanshubin.documentation.domain.diagram

case class Fraction(numerator: Int, denominator: Int) {
  def add(that: Fraction): Fraction = {
    if (this.denominator == that.denominator) {
      Fraction(this.numerator + that.numerator, denominator).lowestTerms
    } else {
      val gcf = Fraction.leastCommonMultiple(this.denominator, that.denominator)
      this.multiplyTerms(gcf / this.denominator).add(that.multiplyTerms(gcf / that.denominator))
    }
  }

  def subtract(that: Fraction): Fraction = this.add(that.negative)

  def multiply(that: Fraction): Fraction = {
    Fraction(this.numerator * that.numerator, this.denominator * that.denominator).lowestTerms
  }

  def divide(that: Fraction): Fraction = {
    this.multiply(that.reciprocal)
  }

  def negative: Fraction = Fraction(-numerator, denominator).lowestTerms

  def reciprocal: Fraction = Fraction(denominator, numerator).lowestTerms

  def lowestTerms: Fraction = {
    val gcf = Fraction.greatestCommonFactor(numerator, denominator)
    Fraction(numerator / gcf, denominator / gcf)
  }

  def multiplyTerms(x: Int): Fraction = {
    Fraction(numerator * x, denominator * x)
  }

  def toDouble: Double = {
    numerator.toDouble / denominator.toDouble
  }
}

object Fraction {
  def greatestCommonFactor(a: Int, b: Int): Int = {
    if (b == 0) a
    else greatestCommonFactor(b, Math.floorMod(a, b))
  }

  def leastCommonMultiple(a: Int, b: Int): Int = {
    Math.abs(a * b) / greatestCommonFactor(a, b)
  }
}
