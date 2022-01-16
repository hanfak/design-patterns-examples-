package dependencyinjection.crosscutting.standard;

import java.time.*;

public interface SystemDate {
    LocalDateTime now();
}

class UtcDate implements SystemDate {

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now(ZoneOffset.UTC);
    }
}

class TestDate implements SystemDate {

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now(Clock.fixed(Instant.parse("2018-08-19T16:45:42.00Z"), ZoneId.systemDefault()));
    }
}

