package com.seanshubin.documentation.core

trait Notifications {
  def greet(target: String)

  def exception(runtimeException: RuntimeException)

  def effectiveConfiguration(configuration: Configuration)

  def configurationError(lines: Seq[String])
}
