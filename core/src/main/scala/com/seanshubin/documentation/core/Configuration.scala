package com.seanshubin.documentation.core

case class Configuration(target:String)

object Configuration {
  val Sample: Configuration = Configuration(
    target = "world"
  )
}
