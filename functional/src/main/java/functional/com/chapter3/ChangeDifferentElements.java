package functional.com.chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChangeDifferentElements {
    public static List<Integer> changeIfEven(List<Integer> aList) {

        return aList.stream()
                .map(ChangeDifferentElements::afunc)
                .collect(Collectors.toList());
    }

    public static Integer afunc(Integer number) {
        return number % 2 != 0 ? number * 10 : number;
    }



    public static void main(String[] args) {
        List<Integer> aList = Arrays.asList(1,2,3,4,5,6);

        List<Integer> changedList = changeIfEven(aList);
        changedList.forEach(System.out::println);
        System.out.println(changedList);

        changedList.stream().filter(Utils::afunc2).forEach(System.out::println);
    }
}

class Utils {
    public static Integer afunc(Integer number) {
        return number % 2 == 0 ? number * 10 : number;
    }

    public static Boolean afunc2(Integer number) { return number % 10 == 0; }
}

