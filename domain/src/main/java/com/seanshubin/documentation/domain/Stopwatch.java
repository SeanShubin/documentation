package com.seanshubin.documentation.domain;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Stopwatch {
    private final Clock clock;
    private Optional<Instant> startTime;
    private Optional<Instant> finishTime;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS Z");

    public Stopwatch(Clock clock) {
        this.clock = clock;
        this.startTime = Optional.empty();
        this.finishTime = Optional.empty();
    }

    public void start() {
        this.startTime = Optional.of(clock.instant());
    }

    public void stop() {
        this.finishTime = Optional.of(clock.instant());
    }

    public void reset() {
        this.startTime = Optional.empty();
        this.finishTime = Optional.empty();
    }

    public long readMillis() {
        if (startTime.isPresent()) {
            if (finishTime.isPresent()) {
                long duration = finishTime.get().toEpochMilli() - startTime.get().toEpochMilli();
                return duration;
            } else {
                long duration = clock.instant().toEpochMilli() - startTime.get().toEpochMilli();
                return duration;
            }
        } else {
            return 0;
        }
    }

    public String startTimeDisplay(ZoneId zone) {
        return startTime.map(instant -> instantToString(instant, zone)).orElse("<not started>");
    }

    public String finishTimeDisplay(ZoneId zone) {
        return finishTime.map(instant -> instantToString(instant, zone)).orElse("<not finished>");
    }

    private String instantToString(Instant instant, ZoneId zoneId) {
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zoneId);
        String formatted = formatter.format(zonedDateTime);
        return formatted;
    }
}
