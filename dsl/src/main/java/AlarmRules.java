import java.time.LocalDateTime;
import java.util.function.Function;
import java.util.function.Predicate;

public class AlarmRules {

    public static Predicate<LocalDateTime> createCondition(LocalDateTime from,
                                                           LocalDateTime to) {
        return currentDateTime -> (currentDateTime.isAfter(from) || currentDateTime.isEqual(from)) && currentDateTime.isBefore(to);
    }

    public static Function<Boolean, Alarm> createAlarm(LocalDateTime from,
                                                       LocalDateTime to) {
        return newState -> new Alarm(newState, from, to);
    }
}
