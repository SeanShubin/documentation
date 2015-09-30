package com.seanshubin.documentation.core

import org.scalatest.FunSuite

import scala.collection.mutable.ArrayBuffer

class RunnerImplTest extends FunSuite {
  test("greet target") {
    val notifications = new NotificationsStub
    val runner = new RunnerImpl(notifications, "target")
    runner.run()
    assert(notifications.sideEffects === Seq("start", "join"))
  }

  class NotificationsStub extends Notifications {
    val sideEffects: ArrayBuffer[String] = new ArrayBuffer()

    override def greet(target: String): Unit = sideEffects.append(s"invoked greet($target)")

    override def configurationError(lines: Seq[String]): Unit = ???

    override def effectiveConfiguration(configuration: Configuration): Unit = ???

    override def exception(runtimeException: RuntimeException): Unit = ???
  }

}
