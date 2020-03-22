package javalibraries.datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQueries;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        LocalDateTime timeInTheFuture = LocalDateTime.of(2018, 12, 30, 12, 23, 34);
        System.out.println("timeInTheFuture = " + timeInTheFuture);

        LocalDateTime dateTimeNow = LocalDateTime.now();
        long timeInDaysBetweenNowAndSomeDayInTheFuture = dateTimeNow.until(timeInTheFuture, ChronoUnit.DAYS);
        System.out.println("timeInDaysBetweenNowAndSomeDayInTheFuture = " + timeInDaysBetweenNowAndSomeDayInTheFuture);

        LocalTime gettingLocalTimeFromDateTime = dateTimeNow.query(TemporalQueries.localTime());
        System.out.println("gettingLocalTimeFromDateTime = " + gettingLocalTimeFromDateTime);
        LocalDate gettingLocalDateFromDateTime = dateTimeNow.query(TemporalQueries.localDate());
        System.out.println("gettingLocalDateFromDateTime = " + gettingLocalDateFromDateTime);
        LocalDate convertToLocalDate = dateTimeNow.toLocalDate();
        System.out.println("convertToLocalDate = " + convertToLocalDate);

        LocalDateTime dateTimeNowOnZone = LocalDateTime.now(ZoneId.of("ECT", ZoneId.SHORT_IDS));
        System.out.println("dateTimeNowOnZone = " + dateTimeNowOnZone);

        LocalDateTime plusNumberOfDaysUsingDuration = timeInTheFuture.plus(Duration.ofDays(25));
        System.out.println("plusNumberOfDaysUsingDuration = " + plusNumberOfDaysUsingDuration);

        LocalDateTime dateChangedToFirstDayOfMonth = timeInTheFuture.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("dateChangedToFirstDayOfMonth = " + dateChangedToFirstDayOfMonth);

    }
}
