package gangoffour.factory.factorymethods;

public interface Price {
    static Price fixed(double price) {
        if (price < 0) throw new IllegalArgumentException();
        return new FixedPrice(price);
    }

    static Price range(double minPrice, double maxPrice) {
        if (maxPrice < minPrice) throw new IllegalArgumentException();
        return new RangePrice(minPrice, maxPrice);
    }

    class FixedPrice implements Price {

        private final double price;

        public FixedPrice(double price) {
            this.price = price;
        }
    }

    class RangePrice implements Price {

        private final double minPrice;
        private final double maxPrice;

        public RangePrice(double minPrice, double maxPrice) {
            this.minPrice = minPrice;
            this.maxPrice = maxPrice;
        }
    }
}
