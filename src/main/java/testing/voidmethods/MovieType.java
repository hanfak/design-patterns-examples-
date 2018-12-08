package testing.voidmethods;

public enum MovieType {

    NEW {
        @Override
        public double calculateTotal(int amountOrdered) {
            return 5 * amountOrdered;
        }
    },
    CHILDREN{
        @Override
        public double calculateTotal(int amountOrdered) {
            return 3 * amountOrdered;
        }
    },
    SPECIAL{
        @Override
        public double calculateTotal(int amountOrdered) {
            return 2 * amountOrdered;
        }
    };

    public abstract double calculateTotal(int amountOrdered);
}
