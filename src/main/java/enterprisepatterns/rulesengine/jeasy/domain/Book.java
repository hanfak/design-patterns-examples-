package enterprisepatterns.rulesengine.jeasy.domain;

public class Book {
  private final String title;
  private final String review;

  public Book(String title, String review) {
    this.title = title;
    this.review = review;
  }

  public String getReview() {
    return review;
  }
}
