package testing.testharness;

import java.util.function.Function;

public class BookServiceTest {

  private final BookService bookService = new BookService();
  private final CustomAssertions customAssertions = new CustomAssertions();

  private final Book book1 = new Book("Book1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit");
  private final Book book2 = new Book("Book2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut");

  public static void main(String... args) {
    BookServiceTest bookServiceTest = new BookServiceTest();

    bookServiceTest.throwsIllegalArguementExceptionWhenBookIsNull(
            bookService -> bookService.summary(null));
    bookServiceTest.retrievesBookSummaryWhenValidBookProvided();

    System.out.println("All tests passed");
  }

  public <T> void throwsIllegalArguementExceptionWhenBookIsNull(Function<BookService, T> bookServiceFunc) {
    customAssertions.verifyException(() -> bookServiceFunc.apply(bookService), (e -> e instanceof IllegalArgumentException));
  }

  public void retrievesBookSummaryWhenValidBookProvided() {
    customAssertions.verify(
            () -> bookService.summary(book1),
            summary -> summary != null && summary.equals("[Book1] - Lorem ipsum dolor sit amet, consectetur adipiscing elit"),
            "'Book1' summary not found");

    customAssertions.verify(
            () -> bookService.summary(book2),
            summary -> summary != null && summary.equals("[Book2] - Lorem ipsum dolor sit amet, consectetur adipiscing elit sed"),
            "'Book2' summary not found");
  }

}