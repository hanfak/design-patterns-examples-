package enterprisepatterns.rulesengine.versionone;

import enterprisepatterns.rulesengine.versionone.domain.Book;
import enterprisepatterns.rulesengine.versionone.domain.ClassifiedBook;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RunnerTwo {
  public static void main(String... args) {
    // exactly 9 words with puncuation at end
    Book harryPotterBook = new Book("Harry Potter Book 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed.");
    // less than 9 words
    Book harryPotter2Book = new Book("Harry Potter Book 2", "Lorem ipsum dolor sit amet, consectetur adipiscing");
    // more than 9 words with comma at end
    Book harryPotter3Book = new Book("Harry Potter Book 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed, do eiusmod tempor incididunt ut asfa");
    // more than 9 words with no comma at end
    Book harryPotter4Book = new Book("Harry Potter Book 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut");

    // This allows us to use multiple groups of rules for specific versions.
    // One situation will use version_1 rule set, ie long summary only when 9 or more words, add ellipse to end and/replace comma
    // Another situation will use version_2 rule set, ie all summary must have certain names obfuscated for important documents
    // This helps collate all rules for specific actions, ie get summary, into one place. Acts a sort of designpatterns.gangoffour.factory
    List<Book> books = Arrays.asList(harryPotterBook, harryPotter2Book, harryPotter3Book, harryPotter4Book);
    books.stream()
            .map(book -> new RuleRunner<>(SummaryRulesAggregator.VERSION_1.getRules())
                    .runRules(book))
            .map(bookSummary -> String.format("Summary = %s\n\n", bookSummary))
            .forEach(System.out::println);

    Book secretBook = new ClassifiedBook("Top secrete", "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt");
    List<Book> classifiedBook = Collections.singletonList(secretBook);
    classifiedBook.stream()
            .map(book -> new RuleRunner<>(SummaryRulesAggregator.VERSION_2.getRules())
                    .runRules(book))
            .map(bookSummary -> String.format("ClassifiedSummary = %s\n\n", bookSummary))
            .forEach(System.out::println);
  }
}
