package datetime;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.ValueRange;

public class LocalTimeExamples {
    public static void main(String[] args) {
        LocalTime timeNow = LocalTime.now();
        System.out.println("timeNow = " + timeNow);

        LocalTime createdTimeHourAndMinute = LocalTime.of(11, 58);
        System.out.println("createdTimeHourAndMinute = " + createdTimeHourAndMinute);
        LocalTime createdTimeHourMinuteSecond = LocalTime.of(11, 58, 45);
        System.out.println("createdTimeHourMinuteSecond = " + createdTimeHourMinuteSecond);

//        LocalTime.from() use in with localDateTime

        LocalTime midnight = LocalTime.MIDNIGHT;
        System.out.println("midnight = " + midnight);

        timeNow.getHour();

        LocalTime timeNowTruncated = timeNow.truncatedTo(ChronoUnit.MINUTES);
        System.out.println("timeNowTruncated = " + timeNowTruncated);

        ValueRange range = timeNow.range(ChronoField.MINUTE_OF_HOUR);
        System.out.println("range = " + range);
    }
}
