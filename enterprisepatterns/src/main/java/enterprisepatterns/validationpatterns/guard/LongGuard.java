package enterprisepatterns.validationpatterns.guard;

public class LongGuard extends BaseGuard<Long> {
    public LongGuard(long value) {
        super(value);
    }

    public void againstNonPositive(String message) {
        against(this::isNonPositive, message);
    }

    private boolean isNonPositive() {
        var result = value <= 0;
        return result;
    }
}
