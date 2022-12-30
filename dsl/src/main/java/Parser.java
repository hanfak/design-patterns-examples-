import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {
    public Map.Entry<Predicate<LocalDateTime>, Function<Boolean, Alarm>> parse(String userRule) {
        Pattern regexPattern = Pattern.compile("^[Cc]hange alarm state to(.*)when(.*)$");
        Matcher m = regexPattern.matcher(userRule);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(1) );
            boolean newState = Boolean.parseBoolean(m.group(1));
            System.out.println("Found value: " + m.group(2) );
            List<LocalDateTime> toAndFromDates = parseDates(m.group(2));

        } else {
            System.out.println("NO MATCH");
        }
        return null;
    }

    private List<LocalDateTime> parseDates(String condition) {
        Pattern regexPattern = Pattern.compile("^$");
        Matcher m = regexPattern.matcher(condition);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(1) );
            // convert day to date for next day upcoming
            String day =  m.group(1);
            System.out.println("Found value: " + m.group(2) );
            // Convert to 24 hour from 12 hour if am/pm
            String timeFromHour =  m.group(2).split(":")[0];
            String timeFromMinute =  m.group(2).split(":")[1];
            System.out.println("Found value: " + m.group(3) );
            int year = Instant.now().get(ChronoField.YEAR);
//            LocalDateTime.of()
        } else {
            System.out.println("NO MATCH");
        }
        return Collections.emptyList();
    }

    public static void main(String... args) {
        new Parser().parse("Change alarm state to off when Monday from 6am to 9am");
    }
}
