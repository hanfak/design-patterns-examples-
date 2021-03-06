package enterprisepatterns.rulesengine.versionone.rules;

import enterprisepatterns.rulesengine.versionone.Rule;
import enterprisepatterns.rulesengine.versionone.domain.Book;
import enterprisepatterns.rulesengine.versionone.domain.ClassifiedBook;

import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.nCopies;

public class obfuscateAllRule implements Rule<Book, String> {
  @Override
  public boolean matches(Book input) {
    return input instanceof ClassifiedBook;
  }

  @Override
  public String process(Book input) {
    int lengthOfReview = new StringTokenizer(input.getReview()).countTokens();
    String[] wordsReview = input.getReview().split("\\s+");
    return IntStream.rangeClosed(0, lengthOfReview - 1)
            .limit(9)
            .mapToObj(index -> String.join("", nCopies(wordsReview[index].length(), "*")))
            .collect(Collectors.joining(" "));

  }
}
