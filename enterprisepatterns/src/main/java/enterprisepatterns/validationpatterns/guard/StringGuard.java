package enterprisepatterns.validationpatterns.guard;

public class StringGuard extends BaseGuard<String> {

    public StringGuard(String value) {
        super(value);
    }

    public String againstNullOrWhitespace(String message) {
        return against(this::isNullOrWhitespace, message);
    }

    private boolean isNullOrWhitespace() {
        return value == null || value.trim().equals("");
    }
}
