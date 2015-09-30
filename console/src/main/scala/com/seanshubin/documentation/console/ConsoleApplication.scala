package com.seanshubin.documentation.console

object ConsoleApplication extends App with LaunchLifecycleWiring {
  override def commandLineArguments: Seq[String] = args

  launcher.launch()
}
