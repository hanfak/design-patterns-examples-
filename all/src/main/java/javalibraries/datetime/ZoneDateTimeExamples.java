package javalibraries.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ZoneDateTimeExamples {
    public static void main(String[] args) {
        ZonedDateTime zoneDateTimeNow = ZonedDateTime.now();
        System.out.println("zoneDateTimeNow = " + zoneDateTimeNow);
        LocalDate zoneDateTolocalDate = zoneDateTimeNow.toLocalDate();
        System.out.println("zoneDateTolocalDate = " + zoneDateTolocalDate);
        LocalDateTime zoneDateToLocalDateTime = zoneDateTimeNow.toLocalDateTime();
        System.out.println("zoneDateToLocalDateTime = " + zoneDateToLocalDateTime);

        ZonedDateTime manuallyCreatedZoneDateTime = ZonedDateTime.of(2017, 3, 5, 13, 17, 46, 211, ZoneId.systemDefault());
        System.out.println("manuallyCreatedZoneDateTime = " + manuallyCreatedZoneDateTime);

        ZonedDateTime createZoneDateFromOtherTimeClasses = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.systemDefault());
        System.out.println("createZoneDateFromOtherTimeClasses = " + createZoneDateFromOtherTimeClasses);


        ZonedDateTime zoneDateTimeInAmerica = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("zoneDateTimeInAmerica = " + zoneDateTimeInAmerica);
        ZoneOffset zoneOffset = zoneDateTimeInAmerica.getOffset();
        System.out.println("zoneOffset = " + zoneOffset);


        ZonedDateTime zonedDateTimeTotheHour = zoneDateTimeInAmerica.truncatedTo(ChronoUnit.HOURS);
        System.out.println("zonedDateTimeTotheHour = " + zonedDateTimeTotheHour);
        ZonedDateTime zonedDateTimeTotheMinute = zoneDateTimeInAmerica.truncatedTo(ChronoUnit.MINUTES);
        System.out.println("zonedDateTimeTotheMinute = " + zonedDateTimeTotheMinute);

        String zoneDateFormattedToStandard = zoneDateTimeNow.format(DateTimeFormatter.ISO_TIME);
        System.out.println("zoneDateFormattedToStandard = " + zoneDateFormattedToStandard);

        ZonedDateTime dateTime = ZonedDateTime.parse("2018-09-03T11:38:45.902-07:00[America/Los_Angeles]", DateTimeFormatter.ISO_DATE_TIME);
    }
}
