package enterprisepatterns.tabledriven._01example;

/*
* A simple solution, would be to return a simple function with logical checks resulting correct output
*
* Notes:
*  - What should the output be - String/decimal/money?
*  - who will use it?
*       - library used by anybody? More defensive, signature will need to be improved upon (output/input/checked exception),
* package, interface, dependencies, how will it be integrated
*       - internal code? package, interface, do we need defensive code if check is done elsewhere
*       - part of a webserver? if exception -> internal exception caught by exception handler
*
* */

public class _01Solution {

    static String price(int amount) {
        // Can use curly braces
        if (amount >= 1 && amount <= 5) return "5";
        if (amount >= 6 && amount <= 10) return "4";
        if (amount >= 11 && amount <= 20) return "3";
        if (amount > 21) return "2.5";

        return "Unknown price";
    }

    public static void main(String... args) {
        System.out.println(price(0));
        System.out.println(price(3));
        System.out.println(price(8));
        System.out.println(price(15));
        System.out.println(price(30));
        int amount = Integer.MAX_VALUE + 1;
        System.out.println("amount = " + amount);
        System.out.println(price(amount));
    }
}
/*
Good:
    - Easy to follow
    - Easy to add new check
    - Good for mvp

Issues:
    - If lots of changes, then can be hard to maintain
    - Once multiple rules are added becomes harder to understand
    - amount is int, this can lead to overflow issues with number bigger than 2147483647
        - Is the values correct? Has then been research in this ie stats/logs etc?
    - Issues if different data is added to make a decision, then every predicate will need to change
    - Issues if action changes, then every block of if statements changes
    - Should a string really be returned? What about null/exception/optional?
    - Who will update the data set for the rules check? devs? users?


* */
