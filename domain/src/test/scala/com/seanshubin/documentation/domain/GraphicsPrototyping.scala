package com.seanshubin.documentation.domain

import java.awt._
import java.awt.font.FontRenderContext
import java.awt.image.BufferedImage

object GraphicsPrototyping extends App {
  def displayScreenDevice(screenDevice: GraphicsDevice): Unit = {
    println(screenDevice)
  }

  def displayConfiguration(configuration: GraphicsConfiguration): Unit = {
    println(configuration)
  }

  val graphicsEnvironment: GraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment
  graphicsEnvironment.getScreenDevices.foreach(displayScreenDevice)
  val screenDevice: GraphicsDevice = graphicsEnvironment.getDefaultScreenDevice
  screenDevice.getConfigurations.foreach(displayConfiguration)
  val graphicsConfiguration: GraphicsConfiguration = screenDevice.getDefaultConfiguration
  val bufferedImage: BufferedImage = graphicsConfiguration.createCompatibleImage(100, 100)
  val graphics: Graphics = bufferedImage.getGraphics
  val graphics2D: Graphics2D = graphics.asInstanceOf[Graphics2D]
  val fontRenderContext: FontRenderContext = graphics2D.getFontRenderContext
  val fonts = graphicsEnvironment.getAllFonts

  def isTheFontWeAreLookingFor(font: Font): Boolean = {
    font.getName == "Consolas"
  }

  val filteredFonts = fonts.filter(isTheFontWeAreLookingFor).toSeq
  val Seq(consolas) = filteredFonts
  val fontMetrics: FontMetrics = graphics.getFontMetrics(consolas)
  val height: Int = fontMetrics.getHeight
  val width: Int = fontMetrics.stringWidth("hello world")
  println(s"height = $height, width = $width")
  println(consolas.createGlyphVector(fontRenderContext, "hello").getOutline.getBounds)
}

