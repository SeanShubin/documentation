package com.seanshubin.documentation.core;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StopwatchTest {
    private static class TestClock extends Clock {
        private long nowAsFarAsTestIsConcerned = 1443563531705L;

        public void passTimeMillis(Long timeToPass) {
            nowAsFarAsTestIsConcerned += timeToPass;
        }

        @Override
        public ZoneId getZone() {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public Clock withZone(ZoneId zone) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public Instant instant() {
            return Instant.ofEpochMilli(nowAsFarAsTestIsConcerned);
        }
    }

    @Test
    public void keepDisplayingZeroIfNotRunning() {
        TestClock clock = new TestClock();
        Stopwatch stopwatch = new Stopwatch(clock);
        assertThat(stopwatch.readMillis(), is(0L));
        clock.passTimeMillis(1000L);
        assertThat(stopwatch.readMillis(), is(0L));
    }

    @Test
    public void displaySecondsElapsedWhileRunning() {
        TestClock clock = new TestClock();
        Stopwatch stopwatch = new Stopwatch(clock);
        stopwatch.start();
        clock.passTimeMillis(1000L);
        assertThat(stopwatch.readMillis(), is(1000L));
        clock.passTimeMillis(1000L);
        assertThat(stopwatch.readMillis(), is(2000L));
    }

    @Test
    public void displaySecondsElapsedDoesNotChangeWhileStopped() {
        TestClock clock = new TestClock();
        Stopwatch stopwatch = new Stopwatch(clock);
        stopwatch.start();
        clock.passTimeMillis(1000L);
        stopwatch.stop();
        assertThat(stopwatch.readMillis(), is(1000L));
        clock.passTimeMillis(1000L);
        assertThat(stopwatch.readMillis(), is(1000L));
    }

    @Test
    public void resetGoesBackToInitialState() {
        TestClock clock = new TestClock();
        Stopwatch stopwatch = new Stopwatch(clock);
        stopwatch.start();
        clock.passTimeMillis(1000L);
        stopwatch.stop();
        clock.passTimeMillis(1000L);
        stopwatch.reset();
        assertThat(stopwatch.readMillis(), is(0L));
        assertThat(stopwatch.readMillis(), is(0L));
    }

    @Test
    public void displayStartAndFinishTimes() {
        ZoneId zoneId = ZoneId.of("America/Los_Angeles");
        TestClock clock = new TestClock();
        Stopwatch stopwatch = new Stopwatch(clock);
        assertThat(stopwatch.startTimeDisplay(zoneId), is("<not started>"));
        assertThat(stopwatch.finishTimeDisplay(zoneId), is("<not finished>"));
        stopwatch.start();
        clock.passTimeMillis(1000L);
        assertThat(stopwatch.startTimeDisplay(zoneId), is("2015-09-29 14:52:11.705 -0700"));
        assertThat(stopwatch.finishTimeDisplay(zoneId), is("<not finished>"));
        stopwatch.stop();
        clock.passTimeMillis(1000L);
        assertThat(stopwatch.startTimeDisplay(zoneId), is("2015-09-29 14:52:11.705 -0700"));
        assertThat(stopwatch.finishTimeDisplay(zoneId), is("2015-09-29 14:52:12.705 -0700"));
    }
}
