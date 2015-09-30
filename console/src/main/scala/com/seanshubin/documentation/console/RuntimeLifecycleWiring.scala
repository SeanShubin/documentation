package com.seanshubin.documentation.console

import com.seanshubin.devon.core.devon.{DevonMarshaller, DevonMarshallerWiring}
import com.seanshubin.documentation.core._

trait RuntimeLifecycleWiring {
  def configuration: Configuration

  lazy val emitLine: String => Unit = println
  lazy val clock: Clock = new ClockIntegration()
  lazy val devonMarshaller: DevonMarshaller = DevonMarshallerWiring.Default
  lazy val notifications: Notifications = new LineEmittingNotifications(clock, devonMarshaller, emitLine)
  lazy val runner: Runner = new RunnerImpl(notifications, configuration.target)
}

object RuntimeLifecycleWiring {
  def createRunnerFromConfiguration(theConfiguration: Configuration): Runner = {
    new RuntimeLifecycleWiring {
      override def configuration: Configuration = theConfiguration
    }.runner
  }
}
