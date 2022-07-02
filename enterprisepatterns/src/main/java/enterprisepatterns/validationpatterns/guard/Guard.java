package enterprisepatterns.validationpatterns.guard;


public final class Guard {

    private Guard() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static LongGuard guard(long value) {
        return new LongGuard(value);
    }

    public static ObjectGuard guard(Object value) { return new ObjectGuard(value); }

    public static StringGuard guard(String value) {
        return new StringGuard(value);
    }

    public static IntGuard guard(int value) {
        return new IntGuard(value);
    }
}
