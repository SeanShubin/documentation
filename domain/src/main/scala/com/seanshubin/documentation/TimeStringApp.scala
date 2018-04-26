package com.seanshubin.documentation

object TimeStringApp extends App {
  val input = "12:32 34:01 15:23 9:27 55:22 25:56"
  val expected = "2:32:41"

  def assertEquals(actual: String, expected: String): Unit = {
    if (actual == expected) {
      println(s"SUCCESS: $actual")
    } else {
      println(s"FAILURE: expected '$expected', got '$actual'")
    }
  }
}
