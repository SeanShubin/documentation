package com.seanshubin.documentation.core

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

object FianceSample extends App {
  val s1 = ("fiancé", "for the ' é ', we are using Latin-1 Supplement: LATIN SMALL LETTER E WITH ACUTE")
  val s2 = ("fiancé", "for the ' é ', we are using Combining Diacritical Marks: COMBINING ACUTE ACCENT")
  val s3 = ("ﬁancé", "for the ' ﬁ ', we are using Alphabetic Presentation Forms: LATIN SMALL LIGATURE FI")
  val s4 = ("𝖿𝗂𝖺𝗇𝖼𝖾", "for all of the characters, we are using Mathematical Alphanumeric Symbols")
  val samples = Seq(s1, s2, s3, s4)
  val header =
    """<!DOCTYPE html>
      |<html lang="en">
      |<head>
      |    <style>
      |        table {
      |            border-collapse: collapse;
      |        }
      |
      |        table, th, td {
      |            border: 1px solid black;
      |            padding: 5px;
      |        }
      |    </style>
      |    <meta charset="UTF-8">
      |    <title>Fiance</title>
      |</head>
      |<body>
      |""".stripMargin
  val footer =
    """</body>
      |</html>
      |""".stripMargin

  val generateWord: (String, String) => String = (word, caption) => {
    val p = s"  <p>$word - $caption</p>"
    val header =
      """
        |  <table>
        |    <tbody>
        |""".stripMargin
    val footer =
      """
        |    </tbody>
        |  </table>
        |""".stripMargin
    val body = generateRows(word)
    p + header + body + footer
  }

  val charFunction: Char => String = x => x.toString
  val utf16Function: Char => String = x => x.toInt.toHexString.toUpperCase()

  val functions = Seq(("character", charFunction), ("UTF-16", utf16Function))

  def generateRows(word: String): String = {
    functions.map { case (c, f) => generateRow(c, word, f) }.mkString("\n")
  }

  def generateRow(caption: String, word: String, charToString: Char => String): String = {
    val row = "      <tr><td>" + caption + "</td>" + word.map(charToString).mkString("<td>", "</td><td>", "</td>") + "</tr>"
    row
  }

  def generateCharacter(ch: Char): String = {
    s"$ch"
  }

  def unicodeCharacter(ch: Char): String = {
    ch.toInt.toString
  }

  val charset = StandardCharsets.UTF_8
  val path = Paths.get("videos", "fiance.html")

  def emit(s: String): Unit = {
    println(s)
    val bytes = s.getBytes(charset)
    Files.write(path, bytes)
  }

  val body = samples.map(generateWord.tupled).mkString("  <hr>\n")
  val text = header + body + footer
  emit(text)
}
