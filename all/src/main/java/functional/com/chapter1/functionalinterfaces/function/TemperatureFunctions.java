package functional.com.chapter1.functionalinterfaces.function;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * Created by hanfak on 24/06/2017.
 */
public class TemperatureFunctions {
    public static Function<Integer, Double> fahrenheitToCentigradeInt = x -> (double) (x - 32) *5 / 9;

    public static Function<Integer, BigDecimal> fahrenheitToCentigrade2DP = x -> {
        BigDecimal bigDecimal = new BigDecimal((double) (x - 32) * 5 / 9);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    };
}
