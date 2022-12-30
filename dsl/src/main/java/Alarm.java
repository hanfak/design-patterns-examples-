import java.time.LocalDateTime;

public record Alarm(
        // new title of alarm
        // boolean recurring
        boolean state,
        LocalDateTime from,
        LocalDateTime to
        ) {

}
