package functional.com.chapter1.functionalinterfaces.function;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TemperatureConvertor {

    public static void main(String[] args) {
        Function<Integer, Double> centigradeToFahrenheitInt = x -> (double) ((x * 9 / 5) + 32);

        System.out.println("(using lambda defined in class) Centigrade to Fahrenheit: "
                + centigradeToFahrenheitInt.apply(10));
        System.out.println("(using lambda defined in other class) Fahrenheit to Centigrade: "
                + TemperatureFunctions.fahrenheitToCentigradeInt.apply(50));


        System.out.println("\ncomposition");
        Function<Integer, Integer> times2 = e -> e * 2;

        Function<Integer, Integer> squared = e -> e * e;

        System.out.println("Compose the function first, do the squared then pass output as input to times2");
        System.out.println(times2.compose(squared).apply(4));
        System.out.println("Passes input to times2 and output is passed to squared");
        System.out.println(times2.andThen(squared).apply(4));


        System.out.println("\nmapping function to list of temperatures");
        List<Integer> temperatures = new ArrayList<>();
        temperatures.addAll(Arrays.asList(10,20,30,40,50));

        List<String> temps = temperatures.stream()
                .map(TemperatureFunctions.fahrenheitToCentigradeInt)
                .map(x -> x + " degrees C")
                .collect(Collectors.toList());
        System.out.println(temps);
        List<BigDecimal> tempsTo2dp = temperatures.stream()
                .map(TemperatureFunctions.fahrenheitToCentigrade2DP)
                .collect(Collectors.toList());
        System.out.println(tempsTo2dp);
    }
}
