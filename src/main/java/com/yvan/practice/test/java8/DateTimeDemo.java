package com.yvan.practice.test.java8;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class DateTimeDemo {

    public void test() {
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());


        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now(clock);
        System.out.println(date);
        System.out.println(dateFromClock);
        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now(clock);
        System.out.println(time);
        System.out.println(timeFromClock);
    }

    public void instantTest() throws InterruptedException {
        Instant begin = Instant.now();
        Thread.sleep(1234);
        Instant end = Instant.now();

        Duration duration = Duration.between(begin, end);
        System.out.println("millis = " + duration.toMillis());
        System.out.println("begin = " + begin.toEpochMilli());
        System.out.println("end = " + end.toEpochMilli());
    }

    public void localDateTest() {
        LocalDate now = LocalDate.now();
        LocalDate now2 = LocalDate.of(2017, 1, 1);
        LocalDate now3 = LocalDate.of(2018, 2, 1);

        System.out.println(now.plusDays(1).toString());
        System.out.println(now2.plus(Period.of(1, 2, 3)).toString());
        System.out.println(now3.withYear(2019).toString());
        System.out.println(now2.until(now3).toString());
        System.out.println(now3.getDayOfWeek());
        System.out.println(DayOfWeek.FRIDAY.plus(2));
        System.out.println(YearMonth.now());
    }

    public void adjustersTest(){
        System.out.println(LocalDate.of(2018, 7, 10).with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).toString());
        System.out.println(LocalDate.of(2018, 7, 10).with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY)).toString());
        System.out.println(LocalDate.of(2018, 7, 10).with(TemporalAdjusters.firstDayOfMonth()).toString());
    }
    
    public void localTimeTest(){
        LocalTime now = LocalTime.now();
        System.out.println(now.plusNanos(10));

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.plusDays(1).toString());
        ZonedDateTime now1 = ZonedDateTime.now();
        System.out.println(now1.getZone());

        System.out.println(DateTimeFormatter.ISO_DATE.format(LocalDateTime.now()));
        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now()));
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));
        System.out.println(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(OffsetDateTime.now()));
        System.out.println(DateTimeFormatter.ISO_ZONED_DATE_TIME.format(now1));
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(now1));
    }


}
