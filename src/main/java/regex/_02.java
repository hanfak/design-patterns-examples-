package regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02 {
  public static void main(String... args) {
    System.out.println("\nExample one");
    String text = "Cindarella and Sleeping Beauty sat in a tree";
    // If two characters (or other subpatterns) follow each other in a regular expression, that means that both the first and the second subpattern must match the target string
    // there is implicitly an and operator in between them. This means, that the target string must match all 3 subpatterns in the given order to match the regular expression as a whole.
    Pattern pattern = Pattern.compile("[Cc][Ii].*");// The string should start with either an uppercase or lowercase C, followed by an uppercase or lowercase I and then zero or more characters.
    Matcher matcher = pattern.matcher(text);

    output(matcher);

    System.out.println("\nExample two");
    String text2 = "Cindarella and Sleeping Beauty sat in a tree";
    //contains two subexpression with the logical or operator in between:
    Pattern pattern2 = Pattern.compile(".*Ariel.*|.*Sleeping Beauty.*");// the pattern will match either the subpattern Ariel or the subpattern Sleeping Beauty somewhere in the target string.
    Matcher matcher2 = pattern2.matcher(text2);

    output(matcher2);

    System.out.println("\nExample three");

    String t1 = "one two three two one".replaceAll("two", "five");
    System.out.println("t1 = " + t1);

    String t2 = "one two three two one".replaceFirst("two", "five");
    System.out.println("t2 = " + t2);

    String[] t3 = "one two three two one".split("two");
    Arrays.stream(t3).forEach(System.out::println);
  }

  private static void output(Matcher matcher) {
    while (matcher.find()) {
      System.out.println("Found match at: " + matcher.start() + " to " + matcher.end());
    }
  }
}
