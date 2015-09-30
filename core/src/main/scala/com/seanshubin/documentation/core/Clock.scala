package com.seanshubin.documentation.core

import java.time.ZonedDateTime

trait Clock {
  def zonedDateTimeNow(): ZonedDateTime
}
