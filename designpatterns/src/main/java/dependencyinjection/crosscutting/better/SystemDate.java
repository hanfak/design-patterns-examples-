package dependencyinjection.crosscutting.better;

import java.time.*;
import java.util.function.Supplier;

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

class SystemDateFactory {

    private static Supplier<SystemDate> supplier;

    public static LocalDateTime now() {
        return supplier.get().now();
    }

    public static void init(Supplier<SystemDate> _supplier) {
        supplier = _supplier;
    }
}

