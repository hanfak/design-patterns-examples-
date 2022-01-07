package datetime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationsExamples {
    public static void main(String[] args) {
        Duration durationOfMinutes = Duration.of(10, ChronoUnit.MINUTES);
        System.out.println("durationOfMinutes = " + durationOfMinutes);
        Duration durationOfDays = Duration.ofDays(4);
        System.out.println("durationOfDays = " + durationOfDays);
        // Must have seconds in time to use between
        Duration durationBetweenTwoDates = Duration.between(LocalTime.of(11,34,56), LocalTime.of(16,12,4));
        System.out.println("durationBetweenTwoDates = " + durationBetweenTwoDates);
        Duration parsedDuration = Duration.parse("P2DT3H4M");
        System.out.println("parsedDuration = " + parsedDuration);

        //convert minutes into seconds
        long l = durationOfMinutes.get(ChronoUnit.SECONDS);
        System.out.println("l = " + l);

        Duration durationDividedBySomeNumber = durationOfMinutes.dividedBy(5);
        System.out.println("durationDividedBySomeNumber = " + durationDividedBySomeNumber);

        Duration absoluteDurationBetweenTwoTimes = Duration.between(LocalTime.MIDNIGHT, LocalTime.NOON);
        System.out.println("absoluteDurationBetweenTwoTimes = " + absoluteDurationBetweenTwoTimes);

        long numberOfDaysForDurationInSeconds = Duration.ofSeconds(623456).toDays();
        System.out.println("numberOfDaysForDurationInSeconds = " + numberOfDaysForDurationInSeconds);

    }
}
