package testing.testharness;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BookService {
  public String summary(Book book) {
    if (null == book) {
      throw new IllegalArgumentException("Book must exist");
    }
    return String.format("[%s] - %s", book.getTitle(), summarise(book.getReview()));
  }

  private String summarise(String review) {
    return Arrays.stream(review.split(" ")).limit(9).collect(Collectors.joining(" "));
  }
}
