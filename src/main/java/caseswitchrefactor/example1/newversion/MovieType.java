package caseswitchrefactor.example1.newversion;

public enum MovieType {
    /**
     * Alternative way
    NEW(5), CHILDREN(3), SPECIAL(2);

    private final double cost;

    MovieType(double cost) {
        this.cost = cost;
    }

    public double calculateTotal(int amountOrdered) {
        return cost * amountOrdered;
    }
    */

    NEW {
        public double calculateTotal(int amountOrdered) {
            return 5 * amountOrdered;
        }
    },
    CHILDREN{
        public double calculateTotal(int amountOrdered) {
            return 3 * amountOrdered;
        }
    },
    SPECIAL{
        public double calculateTotal(int amountOrdered) {
            return 2 * amountOrdered;
        }
    };

    public abstract double calculateTotal(int amountOrdered);
}
