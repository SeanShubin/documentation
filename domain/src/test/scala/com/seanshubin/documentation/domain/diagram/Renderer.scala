package com.seanshubin.documentation.domain.diagram

class Renderer {
  def pageText(title: String, width: Int, height: Int, elements: Seq[Element]): String = {
    val header =
      s"""<!DOCTYPE html>
         |<html lang="en">
         |<head>
         |    <meta charset="UTF-8">
         |    <title>$title</title>
         |</head>
         |<body>
         |<svg width="$width" height="$height">
         |""".stripMargin
    val footer =
      """</svg>
        |</body>
        |</html>
        |""".stripMargin
    val body = elements.flatMap(_.renderSvg).mkString("\n")
    header ++ body ++ footer
  }
}
