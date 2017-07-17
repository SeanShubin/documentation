package com.seanshubin.documentation.domain

import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets

object ClefSample extends App {
  val highSurrogate = '\uD834'
  val lowSurrogate = '\uDD1E'
  val gClef = "\uD834\uDD1E"

  println(formatLine("unicode code point", bytes(gClef.codePointAt(0))))
  println(formatLine("high surrogate    ", bytes(highSurrogate)))
  println(formatLine("low surrogate     ", bytes(lowSurrogate)))
  println(formatLine("utf 8 bytes       ", gClef.getBytes(StandardCharsets.UTF_8)))
  println(formatLine("utf 16 bytes      ", gClef.getBytes(StandardCharsets.UTF_16)))

  def formatLine(caption: String, bytes: Array[Byte]): String = {
    val bytesString = bytes.map(hexByte).mkString(" ")
    val size = bytes.size
    s"$caption ($size bytes) $bytesString"
  }

  def bytes(x: Int): Array[Byte] = ByteBuffer.allocate(4).putInt(x).array()

  def bytes(x: Char): Array[Byte] = ByteBuffer.allocate(2).putChar(x).array()

  def hexByte(byte: Byte): String = {
    f"$byte%02x"
  }
}
