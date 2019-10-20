package rulesengine.versionone;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LongReviewWithCommaRule implements Rule<Book, String> {
  // Can pass in dependency to extract the process of getting the info to create the predicat in
  // the matches method, or action the process
  private final Summarizer summarizer;

  public LongReviewWithCommaRule(Summarizer summarizer) {
    this.summarizer = summarizer;
  }

  @Override
  public boolean matches(Book input) {
    String nineWordReview = summarizer.createSummaryOfNWordsList(9, input.getReview())
            .get(8);
    boolean lengthOfReviewGreaterThanNineWords = input.getReview()
            .split("\\s+")
            .length > 9;
    return lengthOfReviewGreaterThanNineWords && nineWordReview.endsWith(","); // coudl use mathces with regex  nineWordReview.matches(".*,$")
  }

  @Override
  public String process(Book input) {
    List<String> reviewList = summarizer.createSummaryOfNWordsList(9, input.getReview());
    String lastWord = reviewList.get(8);
    String editedLastWord = lastWord.substring(0, lastWord.length() - 1) + "...";
//    String editedLastWord = lastWord.replaceAll(",$", "..."); // Can use lastWord.replaceAll(",$", "...");
    return String.join(" ", replaceLastWord(reviewList, editedLastWord));
  }

  private List<String> replaceLastWord(List<String> items, String lastItem) {
    Stream<String> allExceptLast = items.stream().limit(items.size() - 1);
    return Stream.concat(allExceptLast, Stream.of(lastItem)).collect(toList());
  }
}
