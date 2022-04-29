package enterprisepatterns.rulesengine.versionone;

import enterprisepatterns.rulesengine.versionone.domain.Book;
import enterprisepatterns.rulesengine.versionone.rules.LongReviewRuleWithNoPunctuationRule;
import enterprisepatterns.rulesengine.versionone.rules.LongReviewWithCommaRule;
import enterprisepatterns.rulesengine.versionone.rules.ShortReviewRule;
import enterprisepatterns.rulesengine.versionone.rules.Summarizer;

import java.util.List;

public class RunnerOne {
  public static void main(String... args) {

    // Using abstract rule runner
    RuleRunner<Book, String> bookSummaryRuleRunner = new RuleRunner<>(new ShortReviewRule(),
            new LongReviewRuleWithNoPunctuationRule(),
            new LongReviewWithCommaRule(new Summarizer()));

    // exactly 9 words with puncuation at end
    Book harryPotterBook = new Book("Harry Potter Book 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed.");
    // exactly 9 words no punctuation at end
    Book harryPotter2Book = new Book("Harry Potter Book 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed");
    // more than 9 words with comma at end
    Book harryPotter3Book = new Book("Harry Potter Book 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed, do eiusmod tempor incididunt ut asfa");
    // more than 9 words with no comma at end
    Book harryPotter4Book = new Book("Harry Potter Book 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut");

    String summary1 = bookSummaryRuleRunner.runRule(harryPotterBook);
    System.out.println("summary1 = " + summary1);
    String summary2 = bookSummaryRuleRunner.runRule(harryPotter2Book);
    System.out.println("summary2 = " + summary2);
    String summary3 = bookSummaryRuleRunner.runRule(harryPotter3Book);
    System.out.println("summary3 = " + summary3);
    String summary4 = bookSummaryRuleRunner.runRule(harryPotter4Book);
    System.out.println("summary4 = " + summary4);

    List<Book> books = List.of(harryPotterBook, harryPotter2Book, harryPotter3Book, harryPotter4Book);
    books.stream()
            .map(bookSummaryRuleRunner::runRule)
            .forEach(System.out::println);


  }

}
