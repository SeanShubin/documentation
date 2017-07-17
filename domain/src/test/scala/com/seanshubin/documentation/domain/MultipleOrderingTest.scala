package com.seanshubin.documentation.domain

import org.scalatest.FunSuite

class MultipleOrderingTest extends FunSuite {
  case class Part(name: String, id: Int)

  val sampleParts = Seq(
    Part("a", 1),
    Part("a", 2),
    Part("a", 3),
    Part("b", 1),
    Part("b", 2),
    Part("b", 3),
    Part("c", 1),
    Part("c", 2),
    Part("c", 3)
  )

  def nameAscIdAsc(left: Part, right: Part): Boolean = {
    Ordering.Tuple2(Ordering.String, Ordering.Int).compare((left.name, left.id), (right.name, right.id)) < 0
  }

  def nameDescIdAsc(left: Part, right: Part): Boolean = {
    Ordering.Tuple2(Ordering.String, Ordering.Int).compare((right.name, left.id), (left.name, right.id)) < 0
  }

  def nameAscIdDesc(left: Part, right: Part): Boolean = {
    Ordering.Tuple2(Ordering.String, Ordering.Int).compare((left.name, right.id), (right.name, left.id)) < 0
  }

  def nameDescIdDesc(left: Part, right: Part): Boolean = {
    Ordering.Tuple2(Ordering.String, Ordering.Int).compare((right.name, right.id), (left.name, left.id)) < 0
  }

  test("sort parts by name asc id asc") {
    assert(sampleParts.sortWith(nameAscIdAsc) ===
      Seq(
        Part("a", 1),
        Part("a", 2),
        Part("a", 3),
        Part("b", 1),
        Part("b", 2),
        Part("b", 3),
        Part("c", 1),
        Part("c", 2),
        Part("c", 3)))
  }

  test("sort parts by name desc id asc") {
    assert(sampleParts.sortWith(nameDescIdAsc) ===
      Seq(
        Part("c", 1),
        Part("c", 2),
        Part("c", 3),
        Part("b", 1),
        Part("b", 2),
        Part("b", 3),
        Part("a", 1),
        Part("a", 2),
        Part("a", 3)))
  }

  test("sort parts by name asc id desc") {
    assert(sampleParts.sortWith(nameAscIdDesc) ===
      Seq(
        Part("a", 3),
        Part("a", 2),
        Part("a", 1),
        Part("b", 3),
        Part("b", 2),
        Part("b", 1),
        Part("c", 3),
        Part("c", 2),
        Part("c", 1)))
  }

  test("sort parts by name desc id desc") {
    assert(sampleParts.sortWith(nameDescIdDesc) ===
      Seq(
        Part("c", 3),
        Part("c", 2),
        Part("c", 1),
        Part("b", 3),
        Part("b", 2),
        Part("b", 1),
        Part("a", 3),
        Part("a", 2),
        Part("a", 1)))
  }
}
