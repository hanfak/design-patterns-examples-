package rulesengine.versionone.rules;

import rulesengine.versionone.Rule;
import rulesengine.versionone.domain.Book;

public class ShortReviewRule implements Rule<Book, String> {

  // Can pass in dependency to extract the process of getting the info to create the predicat in
  // the matches method, or action the process
  @Override
  public boolean matches(Book input) {
    return input.getReview().split("\\s+").length < 10;
  }

  @Override
  public String process(Book input) {
    return input.getReview();
  }
}
