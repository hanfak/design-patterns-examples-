package functional.otherexamples;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class ComposingFunctions {
    public static void main(String[] args) {
        Function<Integer, Integer> times2 = e -> e * 2;

        Function<Integer, Integer> squared = e -> e * e;

        // the compose function executes the caller last and the parameter first
        Integer result1 = times2.compose(squared).apply(4);
        // Returns 32
        System.out.println("result1 = " + result1);

        //the andThen executes the caller first and the parameter last.
        Integer result2 = times2.andThen(squared).apply(4);
        // Returns 64
        System.out.println("result2 = " + result2);


        // Using Bifunctions
        // Only, andThen available,
        // You can't put the result of a function into a function that takes two arguments
        BiFunction<String, List<Article>, List<Article>> byAuthor =
                (name, articles) -> articles.stream()
                        .filter(a -> a.getAuthor().equals(name))
                        .collect(Collectors.toList());

        BiFunction<String, List<Article>, List<Article>> byTag =
                (tag, articles) -> articles.stream()
                        .filter(a -> a.getTags().contains(tag))
                        .collect(Collectors.toList());

        Function<List<Article>, List<Article>> sortByDate =
                articles -> articles.stream()
                        .sorted((x, y) -> y.published().compareTo(x.published()))
                        .collect(Collectors.toList());

        Function<List<Article>, Optional<Article>> first =
                a -> a.stream().findFirst();

        // return the article that was most recently published
        Function<List<Article>, Optional<Article>> newest =
                first.compose(sortByDate);

        //Finding an author's newest article.
        BiFunction<String, List<Article>, Optional<Article>> newestByAuthor =
                byAuthor.andThen(newest);

        // order an author's articles by date
        BiFunction<String, List<Article>, List<Article>> byAuthorSorted =
                byAuthor.andThen(sortByDate);

        // newest article based on your favourite tag
        BiFunction<String, List<Article>, Optional<Article>> newestByTag =
                byTag.andThen(newest);

        // implementation
        LocalDate date = LocalDate.of(2010, 5, 12);
        Article articleOne = new Article("abc", asList("zoo", "bath", "yacht"), date);
        Article articleTwo = new Article("xyz", asList("house", "yacht"), date.plus(2, ChronoUnit.YEARS));
        Article articleThree = new Article("txa", asList("time", "tamborine"), date.minus(2, ChronoUnit.YEARS));
        Article articleFour = new Article("abc", asList("time", "house"), date.minus(2, ChronoUnit.DAYS));
        Article articleFive = new Article("abc", asList("cows", "bath"), date.plus(2, ChronoUnit.DAYS));

        List<Article> articles = asList(articleFive, articleOne, articleFour, articleThree, articleTwo);

        Optional<Article> resultNewestByTag = newestByTag.apply("yacht", articles);
        System.out.println("resultNewestByTag = " + resultNewestByTag.get());

        List<Article> resultByAuthorSorted = byAuthorSorted.apply("abc", articles);
        System.out.println("resultByAuthorSorted = " + resultByAuthorSorted);

        Optional<Article> resultNewestByAuthor = newestByAuthor.apply("abc", articles);
        System.out.println("resultNewestByAuthor = " + resultNewestByAuthor.get());
    }
}


class Article {
    private final String author;
    private final List<String> tags;
    private final LocalDate publishedDate;

    Article(String author, List<String> tags, LocalDate publishedDate) {
        this.author = author;
        this.tags = tags;
        this.publishedDate = publishedDate;
    }

    String getAuthor() {
        return this.author;
    }

    List<String> getTags() {
        return this.tags;
    }

    LocalDate published() {
        return this.publishedDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "author='" + author + '\'' +
                ", tags=" + tags +
                ", publishedDate=" + publishedDate +
                '}';
    }
}
