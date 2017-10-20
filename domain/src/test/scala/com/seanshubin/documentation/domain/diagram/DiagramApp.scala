package com.seanshubin.documentation.domain.diagram

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

object DiagramApp extends App {
  val boxA = Box(100, 0, "class a")
  val boxB = Box(0, 100, "class b")
  val boxC = Box(200, 100, "class c")
  val boxD = Box(100, 200, "class d")
  val arrowAB = Arrow(boxA.bottomLine.fraction(1, 4), boxB.topLine.fraction(1, 2))
  val arrowAC = Arrow(boxA.bottomLine.fraction(3, 4), boxC.topLine.fraction(1, 2))
  val arrowBD = Arrow(boxB.bottomLine.fraction(1, 2), boxD.topLine.fraction(1, 4))
  val arrowCD = Arrow(boxC.bottomLine.fraction(1, 2), boxD.topLine.fraction(3, 4))
  val elements = Seq(boxA, boxB, boxC, boxD, arrowAB, arrowAC, arrowBD, arrowCD)
  val moved = elements.map(_.move(10, 10))
  val renderer = new Renderer()
  val pageText = renderer.pageText("diagram", 500, 500, moved)
  val path = Paths.get("diagram", "diagram-app.html")
  val charset = StandardCharsets.UTF_8
  val bytes = pageText.getBytes(charset)
  Files.write(path, bytes)
}
