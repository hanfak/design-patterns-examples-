package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate dateNow = LocalDate.now();
        System.out.println("dateBow = " + dateNow);

        LocalDate nowPlus3Days = dateNow.plusDays(3);
        System.out.println("nowPlus3Days = " + nowPlus3Days);

        LocalDate nowMinus5Months = dateNow.minus(5, ChronoUnit.MONTHS);
        System.out.println("nowMinus5Months = " + nowMinus5Months);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/uuuu");
        String formattedDate = dateNow.format(formatter);
        System.out.println("formattedDate = " + formattedDate);

        LocalDate someDate = LocalDate.of(2015, Month.JANUARY, 20);
        System.out.println("someDate = " + someDate);
        LocalDate someOtherDate = LocalDate.of(2016, 11, 19);
        System.out.println("someOtherDate = " + someOtherDate);

        boolean equal = dateNow.isEqual(dateNow);
        System.out.println("equal = " + equal);

        boolean before = dateNow.isBefore(dateNow.minusDays(1));
        System.out.println("before = " + before);

        int i = dateNow.get(ChronoField.MONTH_OF_YEAR);
        System.out.println("i = " + i);

        DayOfWeek dayOfWeek = dateNow.getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);

        LocalDate changedDayOfWeek = dateNow.withDayOfMonth(DayOfWeek.FRIDAY.getValue());
        System.out.println("changedDayOfWeek = " + changedDayOfWeek);

        LocalDate dateWithChangedYear = dateNow.with(ChronoField.YEAR, 2024);
        System.out.println("dateWithChangedYear = " + dateWithChangedYear);

        LocalDate parseDate = LocalDate.parse("2016-08-16");
        System.out.println("parseDate = " + parseDate);

        LocalDate parsedDateFormatted = LocalDate.parse("16-Aug-2016", DateTimeFormatter.ofPattern("d-MMM-yyyy"));
        System.out.println("parsedDateFormatted = " + parsedDateFormatted);

        LocalDate parsedDateWordFormatted = LocalDate.parse("Tue, Aug 16 2016", DateTimeFormatter.ofPattern("E, MMM d yyyy"));
        System.out.println("parsedDateWordFormatted = " + parsedDateWordFormatted);

    }
}
