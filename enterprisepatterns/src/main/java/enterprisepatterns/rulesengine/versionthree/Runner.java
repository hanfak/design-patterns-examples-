package enterprisepatterns.rulesengine.versionthree;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class Runner {
    // We can implement the ideas of rules using a Map the uses predicates as keys and functions as values
    // Instead of function can use a Consumer if you are modifiying some state
    private final static Map<Predicate<Book>, Function<Book, String>> rules = new LinkedHashMap<>();
    // Use linkedMap to maintain order during iteration of rules
    // IF rules are not affected by the order of the iteration can use hashmap
    static {
                rules.put(input -> input.description().split("\\s+").length < 9, Book::description);
                rules.put(Runner::longReviewWithComma, Runner::summarise);
                rules.put(Runner::longReviewWithNoEndingPunctuation, Runner::summarise2);
    }

    public String applyRules(Book book) {
        return rules.entrySet().stream()
                .filter(e -> e.getKey().test(book))
                .findFirst() // Dont have to use can return set of all rules passed with output
                .map(e -> e.getValue().apply(book))
                .orElse("Default if no rule match"); // or This can throw exception if no rules match
    }

    private static String summarise2(Book book) {
        return stream(book.description()
                .split("\\s+"))
                       .limit(9)
                       .collect(Collectors.joining(" "));
    }

    private static boolean longReviewWithNoEndingPunctuation(Book book) {
        String[] words = book.description().split("\\s+");
        return words.length >= 9 && !words[words.length - 1].endsWith(",");
    }

    private static String summarise(Book input) {
        List<String> reviewList = createSummaryOfNWordsList(9, input.description());
        String reviewWithPunc = String.join(" ", reviewList);
        return reviewWithPunc.substring(0, reviewWithPunc.length() - 1) + "...";
    }

    private static boolean longReviewWithComma(Book input) {
        String nineWordReview = createSummaryOfNWordsList(9, input.description()).get(8);
        boolean lengthOfReviewGreaterThanNineWords = input.description().split("\\s+").length > 9;
        return lengthOfReviewGreaterThanNineWords && nineWordReview.endsWith(",");
    }

   private static List<String> createSummaryOfNWordsList(int numberOfWords, String review) {
        return stream(review.split("\\s+")).limit(numberOfWords).collect(toList());
    }

    private static List<String> replaceLastWord(List<String> items, String lastItem) {
        Stream<String> allExceptLast = items.stream().limit(items.size() - 1);
        return Stream.concat(allExceptLast, Stream.of(lastItem)).collect(toList());
    }

    public static void main(String... args) {
        Runner runner = new Runner();
        // less than 9 words
        Book harryPotterBook0 = new Book("Harry Potter Book 0", "Lorem ipsum dolor sit amet,");
        // exactly 9 words with puncuation at end
        Book harryPotterBook = new Book("Harry Potter Book 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed,");
        // exactly 9 words no punctuation at end
        Book harryPotter2Book = new Book("Harry Potter Book 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed");
        // more than 9 words with comma at end
        Book harryPotter3Book = new Book("Harry Potter Book 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed, do eiusmod tempor incididunt ut asfa");
        // more than 9 words with no comma at end
        Book harryPotter4Book = new Book("Harry Potter Book 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed. do eiusmod tempor incididunt ut");
        // exactly 10 words no punctuation at end
        Book harryPotter5Book = new Book("Harry Potter Book 5", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do.");
        Stream.of(harryPotterBook0, harryPotterBook, harryPotter2Book, harryPotter3Book, harryPotter4Book,harryPotter5Book)
                .map(runner::applyRules)
                .forEach(System.out::println);
    }

    public static record Book(String title, String description){};
}
