package functionalclean.better;

public record VehicleId(String value) {

    private static final String PATTERN = "[0-9A-Z]{1,15}";
    // Validation in types
    public VehicleId {
        if (value == null || !value.matches(PATTERN)) {
            throw new IllegalArgumentException("Should match pattern: " + PATTERN);
        }
    }

}
