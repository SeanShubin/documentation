package com.seanshubin.documentation.core

class RunnerImpl(notifications:Notifications, target:String) extends Runner {
  override def run(): Unit = {
    notifications.greet(target)
  }
}
