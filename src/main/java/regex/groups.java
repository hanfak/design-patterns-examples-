package regex;

public class groups {
  public static void main(String... args) {
    String text = "hello password \n";
    String replaced = text.replaceFirst("^[H|h]ello\\s+(.*)\n", "********");
    System.out.println("replaced = " + replaced);
  }
}
