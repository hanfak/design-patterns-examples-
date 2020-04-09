package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01 {
  public static void main(String... args) {
    System.out.println("Example one");
    String text = "This is the text to be searched for occurrences of the http:// pattern.";

    //matches all texts which contains one or more characters (.*)
    // followed by the text http:// followed by one or more characters (.*)
    String regex = ".*http://.*";

    boolean matches = Pattern.matches(regex, text);

    System.out.println("matches = " + matches);

    System.out.println("\nExample two");
    // Finds all occurances of the regex in the text
    String text2 = "This is the text which is to be searched for occurrences of the word 'is' in the sentence.";

    String regex2 = "is";

    Pattern pattern = Pattern.compile(regex2);
    Matcher matcher = pattern.matcher(text2);

    int count = 0;
    while (matcher.find()) {
      count++;
      System.out.println("found: " + count + " : "
              + matcher.start() + " - " + matcher.end());
    }

    System.out.println("\nExample three");
    String text3 = "Line 1\nLine2\nLine3";

    // the ^ character only matches the beginning of the input string, not the beginning of each line (after each line break).
    Pattern pattern3 = Pattern.compile("^");
    Matcher matcher3 = pattern3.matcher(text3);

    output(matcher3);

    System.out.println("\nExample four");

    String text4 = "http://blah.com";

    //The $ boundary matcher matches the end of the line
    Pattern pattern4 = Pattern.compile(".com$");
    Matcher matcher4 = pattern4.matcher(text4);

    output(matcher4);

    System.out.println("\nExample Five");
    // Word boundaries - The \b boundary matcher matches a word boundary, meaning a location in an input string where a word either starts or ends.
    // The output lists all the locations where a word either starts or ends in the input string
    String text5 = "Mary had a little lamb";

    Pattern pattern5 = Pattern.compile("\\b");
    Matcher matcher5 = pattern5.matcher(text5);

    output(matcher5);


    System.out.println("\nExample Six");

    String text6 = "Mary had a little lamb full";

    Pattern pattern6 = Pattern.compile("\\bl"); //find all the locations where a word starts with the letter l (lowercase).
//    Pattern pattern6 = Pattern.compile("l\\b"); //find all the locations where a word ends with the letter l (lowercase).
    Matcher matcher6 = pattern6.matcher(text6);

    output(matcher6);

    System.out.println("\nExample Seven");
    String text7 = "Mary had a little lamb";
    //The \B boundary matcher matches non-word boundaries. A non-word boundary is a boundary between two characters which are both part of the same word
    // the character combination is not word-to-non-word character sequence (which is a word boundary).
    Pattern pattern7 = Pattern.compile("\\B");
    Matcher matcher7 = pattern7.matcher(text7);

    output(matcher7);

    System.out.println("\nExample Eight");
    String text8 = "Mary Hell Help hello Hello Hellooo";
    //matches strings with the text "Hell" followed by zero or more o characters.
//    If the quantifier had been the + character instead of the * character, the string would have had to end with 1 or more o characters.
    Pattern pattern8 = Pattern.compile("Hello*");
//    Pattern pattern8 = Pattern.compile("Hello+");
    Matcher matcher8 = pattern8.matcher(text8);

    output(matcher8);

    System.out.println("\nExample nine");
    String text9 = "Mary Hell Help hello Hell+ Hello Hell+ooo";
    //matches match on Hell+
    Pattern pattern9 = Pattern.compile("Hell\\+");
//    Pattern pattern9 = Pattern.compile("Hell\\++");
    Matcher matcher9 = pattern9.matcher(text9);

    output(matcher9);

    System.out.println("\nExample ten");
    String text10 = "Helloooooo Mary Hello Help Helloooo hello Helloo Hello Hellooo";
    //This regular expression will match the string "Helloo" (with two o characters in the end).
//    Pattern pattern10 = Pattern.compile("Hello{2}");
    //  the string "Hell" with 2, 3 or 4 o characters in the end.
    Pattern pattern10 = Pattern.compile("Hello{2,4}");
    Matcher matcher10 = pattern10.matcher(text10);

    output(matcher10);
  }

  private static void output(Matcher matcher) {
    while (matcher.find()) {
      System.out.println("Found match at: " + matcher.start() + " to " + matcher.end());
    }
  }
}
