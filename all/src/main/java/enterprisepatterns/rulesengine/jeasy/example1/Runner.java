package enterprisepatterns.rulesengine.jeasy.example1;

import enterprisepatterns.rulesengine.versionone.domain.Book;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;

public class Runner {
  public static void main(String... args) {
    // exactly 9 words with puncuation at end
    Book harryPotterBook = new Book("Harry Potter Book 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed.");
    // exactly 9 words no punctuation at end
    Book harryPotter2Book = new Book("Harry Potter Book 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed");
    // more than 9 words with comma at end
    Book harryPotter3Book = new Book("Harry Potter Book 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed, do eiusmod tempor incididunt ut asfa");
    // more than 9 words with no comma at end
    Book harryPotter4Book = new Book("Harry Potter Book 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut");

    Facts facts = new Facts();
    facts.put("review", new Summary(harryPotterBook.getReview()));
    Facts facts1 = new Facts();
    facts1.put("review", new Summary(harryPotter4Book.getReview()));

    Rules rules = new Rules();
    rules.register(new ShortReviewRule());
    rules.register(new LongReviewRuleWithNoPunctuationRule());
    RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);

    RulesEngine rulesEngine = new DefaultRulesEngine(parameters);
    rulesEngine.fire(rules, facts);
    System.out.println((String) facts.get("review"));
    rulesEngine.fire(rules, facts1);
    System.out.println((String) facts1.get("review"));



  }
}
