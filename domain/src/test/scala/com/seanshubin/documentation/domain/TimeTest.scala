package com.seanshubin.documentation.domain

import java.time._

import org.scalatest.FunSuite

class TimeTest extends FunSuite {
  //key concepts
  //  you can't get from a time zone to an offset unless you know the current time (ZoneId -> ZoneOffset needs Instant)
  //  the "local" prefix means it is not a specific time, it is relative to an unspecified time zone (LocalDateTime -> Instant needs ZoneOffset)
  val oneMillisecondAfterBaktun13AsZonedDateTime:ZonedDateTime = ZonedDateTime.parse("2012-12-21T11:11:00.001Z[UTC]")
  val sampleZonedDateTime = oneMillisecondAfterBaktun13AsZonedDateTime
  val sampleInstant:Instant = Instant.parse("2012-12-21T11:11:00.001Z")
  val sampleMilliseconds:Long = 1356088260001L
  val sampleNanosecondsOfAfterSecond:Int = sampleInstant.getNano
  val utcZone = ZoneId.of("UTC")
  val losAngelesZone = ZoneId.of("America/Los_Angeles")

  test("construct zoned date time") {
    val zoneId = ZoneId.of("America/Los_Angeles")
    val localDate = LocalDate.of(2015, 3, 12)
    val localTime = LocalTime.of(13, 43, 11, 933000000)
    val zonedDateTime = ZonedDateTime.of(localDate, localTime, zoneId)
    assert(zonedDateTime.toString === "2015-03-12T13:43:11.933-07:00[America/Los_Angeles]")
    assert(zonedDateTime.getYear === 2015)
    assert(zonedDateTime.getMonthValue === 3)
    assert(zonedDateTime.getDayOfMonth === 12)
    assert(zonedDateTime.getHour === 13)
    assert(zonedDateTime.getMinute === 43)
    assert(zonedDateTime.getSecond === 11)
    assert(zonedDateTime.getNano === 933000000)
    assert(zonedDateTime.getZone.getId === "America/Los_Angeles")
    assert(zonedDateTime.getOffset.getId === "-07:00")
    assert(zonedDateTime.getZone.getRules.getOffset(zonedDateTime.toInstant).getId === "-07:00")
  }

  test("parse zoned date time") {
    val parsed = ZonedDateTime.parse("2015-03-12T13:43:11.933Z[America/Los_Angeles]")
    val parsedLocalDate = LocalDate.parse("2015-03-12")
    val parsedLocalTime = LocalTime.parse("13:43:11.933")
    val zoneId = ZoneId.of("America/Los_Angeles")
    val constructedFromParsed = ZonedDateTime.of(parsedLocalDate, parsedLocalTime, zoneId)
    assert(parsed.toString === "2015-03-12T13:43:11.933-07:00[America/Los_Angeles]")
    assert(constructedFromParsed.toString === "2015-03-12T13:43:11.933-07:00[America/Los_Angeles]")
  }

  test("milliseconds to instant") {
    val instant = Instant.ofEpochMilli(sampleMilliseconds)
    assert(instant.toString === "2012-12-21T11:11:00.001Z")
  }

  test("milliseconds to date time utc") {
    val instant = Instant.ofEpochMilli(sampleMilliseconds)
    val localDateTime1 = LocalDateTime.ofInstant(instant, utcZone)
    assert(localDateTime1.toString === "2012-12-21T11:11:00.001")

    val localDateTime2 = LocalDateTime.ofEpochSecond(
      sampleMilliseconds / 1000,                         //convert milliseconds to seconds
      (sampleMilliseconds % 1000 * 1000 * 1000).toInt,   //this is from the last second, not total nanoseconds, so start from the current second, convert millis to micros, convert micros to nanos
      utcZone.getRules.getOffset(instant))               //for utc the offset is always 0, but not so with other time zones, so still have to provide the time to compute the offest
    assert(localDateTime2.toString === "2012-12-21T11:11:00.001")
  }

  test("milliseconds to date time Los Angeles") {
    //Los Angeles happened to be -8:00 on the date in question, but is sometimes -7:00

    val instant = Instant.ofEpochMilli(sampleMilliseconds)
    val localDateTime1 = LocalDateTime.ofInstant(instant, losAngelesZone)
    assert(localDateTime1.toString === "2012-12-21T03:11:00.001")

    val localDateTime2 = LocalDateTime.ofEpochSecond(
      sampleMilliseconds / 1000,
      (sampleMilliseconds % 1000 * 1000 * 1000).toInt,
      losAngelesZone.getRules.getOffset(instant))
    assert(localDateTime2.toString === "2012-12-21T03:11:00.001")
  }

  test("milliseconds to zoned date time utc") {
    val instant = Instant.ofEpochMilli(sampleMilliseconds)

    val zonedDateTime = ZonedDateTime.ofInstant(instant, utcZone)
    assert(zonedDateTime.toString === "2012-12-21T11:11:00.001Z[UTC]")
  }

  test("milliseconds to zoned date time Los Angeles") {
    val instant = Instant.ofEpochMilli(sampleMilliseconds)

    val zonedDateTime = ZonedDateTime.ofInstant(instant, losAngelesZone)
    assert(zonedDateTime.toString === "2012-12-21T03:11:00.001-08:00[America/Los_Angeles]")
  }

  test("instant to milliseconds") {
    val milliseconds = sampleInstant.toEpochMilli
    assert(milliseconds === sampleMilliseconds)
  }

  test("instant to date time utc") {
    val localDateTime1 = LocalDateTime.ofInstant(sampleInstant, utcZone)
    assert(localDateTime1.toString === "2012-12-21T11:11:00.001")

    val localDateTime2 = LocalDateTime.ofEpochSecond(
      sampleMilliseconds / 1000,                         //convert milliseconds to seconds
      (sampleMilliseconds % 1000 * 1000 * 1000).toInt,   //this is from the last second, not total nanoseconds, so start from the current second, convert millis to micros, convert micros to nanos
      utcZone.getRules.getOffset(sampleInstant))         //for utc the offset is always 0, but not so with other time zones, so still have to provide the time to compute the offest
    assert(localDateTime2.toString === "2012-12-21T11:11:00.001")
  }

  test("instant to date time Los Angeles") {
    //Los Angeles happened to be -8:00 on the date in question, but is sometimes -7:00

    val localDateTime1 = LocalDateTime.ofInstant(sampleInstant, losAngelesZone)
    assert(localDateTime1.toString === "2012-12-21T03:11:00.001")

    val localDateTime2 = LocalDateTime.ofEpochSecond(
      sampleMilliseconds / 1000,
      (sampleMilliseconds % 1000 * 1000 * 1000).toInt,
      losAngelesZone.getRules.getOffset(sampleInstant))
    assert(localDateTime2.toString === "2012-12-21T03:11:00.001")
  }

  test("instant to zoned date time utc") {
    val zonedDateTime = ZonedDateTime.ofInstant(sampleInstant, utcZone)
    assert(zonedDateTime.toString === "2012-12-21T11:11:00.001Z[UTC]")
  }

  test("instant to zoned date time Los Angeles") {
    val zonedDateTime = ZonedDateTime.ofInstant(sampleInstant, losAngelesZone)
    assert(zonedDateTime.toString === "2012-12-21T03:11:00.001-08:00[America/Los_Angeles]")
  }

  test("date time to zoned date time utc") {
    val dateTime = LocalDateTime.parse("2012-12-21T11:11:00.001")
    val zonedDateTime = ZonedDateTime.of(dateTime, utcZone)
    assert(zonedDateTime.toString === "2012-12-21T11:11:00.001Z[UTC]")
  }

  test("date time to zoned date time Los Angeles") {
    val dateTime = LocalDateTime.parse("2012-12-21T11:11:00.001")
    val zonedDateTime = ZonedDateTime.of(dateTime, losAngelesZone)
    assert(zonedDateTime.toString === "2012-12-21T11:11:00.001-08:00[America/Los_Angeles]")
  }

  test("zoned date time to milliseconds") {
    assert(sampleZonedDateTime.toInstant.toEpochMilli === sampleMilliseconds)
  }

  test("zoned date time to instant") {
    assert(sampleZonedDateTime.toInstant === sampleInstant)
  }

  test("zoned date time to date time") {
    assert(sampleZonedDateTime.toLocalDateTime.toString === "2012-12-21T11:11:00.001")
  }
}
