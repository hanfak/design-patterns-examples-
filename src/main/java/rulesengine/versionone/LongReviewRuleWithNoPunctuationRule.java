package rulesengine.versionone;

import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class LongReviewRuleWithNoPunctuationRule implements Rule<Book, String> {
  // Can pass in dependency to extract the process of getting the info to create the predicat in
  // the matches method, or action the process

  @Override
  public boolean matches(Book input) {
// Alternate to finding the non comma ending ninth word
//    String[] words = input.getReview()
//            .split("\\s+");
//    !words[words.length - 1].endsWith(",");
    String ninthWord = stream(input.getReview()
            .split("\\s+"))
            .collect(toList())
            .get(8);
    boolean lengthOfReviewGreaterThanNineWords = input.getReview()
            .split("\\s+")
            .length > 9;
    return lengthOfReviewGreaterThanNineWords && !ninthWord.endsWith(",");
  }

  @Override
  public String process(Book input) {
    return stream(input.getReview()
            .split("\\s+"))
            .limit(9)
            .collect(Collectors.joining(" ")) + "...";
  }
}
