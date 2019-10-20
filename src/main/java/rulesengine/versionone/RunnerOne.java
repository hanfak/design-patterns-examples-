package rulesengine.versionone;

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

    String summary1 = bookSummaryRuleRunner.runRules(harryPotterBook);
    System.out.println("summary1 = " + summary1);
    String summary2 = bookSummaryRuleRunner.runRules(harryPotter2Book);
    System.out.println("summary2 = " + summary2);
    String summary3 = bookSummaryRuleRunner.runRules(harryPotter3Book);
    System.out.println("summary3 = " + summary3);
    String summary4 = bookSummaryRuleRunner.runRules(harryPotter4Book);
    System.out.println("summary4 = " + summary4);
  }

}
