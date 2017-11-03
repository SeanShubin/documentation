package com.seanshubin.documentation.domain.diagram

import org.scalatest.FunSuite

class FractionTest extends FunSuite {
  test("lowest terms") {
    assert(Fraction(1, 2).lowestTerms === Fraction(1, 2))
    assert(Fraction(-1, 2).lowestTerms === Fraction(-1, 2))
    assert(Fraction(1, -2).lowestTerms === Fraction(-1, 2))
    assert(Fraction(-1, -2).lowestTerms === Fraction(1, 2))
    assert(Fraction(6, 9).lowestTerms === Fraction(2, 3))
    assert(Fraction(-6, 9).lowestTerms === Fraction(-2, 3))
    assert(Fraction(6, -9).lowestTerms === Fraction(-2, 3))
    assert(Fraction(-6, -9).lowestTerms === Fraction(2, 3))
  }

  test("add") {
    assert(Fraction(2, 3).add(Fraction(3, 8)) === Fraction(25, 24))
  }

  test("subtract") {
    assert(Fraction(2, 3).subtract(Fraction(3, 8)) === Fraction(7, 24))
  }

  test("multiply") {
    assert(Fraction(2, 3).multiply(Fraction(3, 4)) === Fraction(1, 2))
  }

  test("divide") {
    assert(Fraction(1, 2).divide(Fraction(3, 4)) === Fraction(2, 3))
  }

}
