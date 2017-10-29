package com.seanshubin.documentation.domain

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

object SvgGenerator extends App {
  def box(x: Int, y: Int, text: String, link: String): String = {
    val width = 40 + text.length * 11
    val textX = x + 20
    val textY = y + 40
    val boxCommands =
      s"""<rect x="$x" y="$y" rx="20" ry="20" width="$width" height="70" fill="none" stroke="black" stroke-width="3"/>
         |<a href="$link">
         |<text x="$textX" y="$textY" fill="blue" font-family="Consolas" font-size="20" font-weight="bold">$text</text>
         |</a>
         |""".stripMargin
    boxCommands
  }

  def top(width: Int, height: Int, parts: String*): String = {
    val header =
      s"""<!DOCTYPE html>
         |<html lang="en">
         |<head>
         |    <meta charset="UTF-8">
         |    <title>Svg Sample</title>
         |</head>
         |<body>
         |<svg width="$width" height="$height">
         |""".stripMargin
    val footer =
      """</svg>
        |</body>
        |</html>
        |""".stripMargin
    val body = parts.mkString("\n")
    header ++ body ++ footer
  }

  val hi = box(10, 10, "hi", "https://www.google.com/search?q=hi")
  val hello = box(10, 110, "hello", "https://www.google.com/search?q=hello")
  val world = box(10, 210, "whole wide world", "https://www.google.com/search?q=world")
  val html = top(500, 1000, hi, hello, world)

  val path = Paths.get("diagram", "svg-generated.html")
  val charset = StandardCharsets.UTF_8
  val bytes = html.getBytes(charset)
  Files.write(path, bytes)
}

