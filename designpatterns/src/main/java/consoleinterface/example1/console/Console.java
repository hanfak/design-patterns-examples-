package consoleinterface.example1.console;


import consoleinterface.example1.domain.Post;

import java.util.List;
import java.util.Scanner;

public class Console {

  public static final String PROMPT = "> ";
  private final Scanner scanner;

  public Console() {
    scanner = new Scanner(System.in);
  }

  public String readline() {
    System.out.print(PROMPT);
    return scanner.nextLine();
  }

  public void write(String output) {
    System.out.println(output);
  }

  public void write(List<Post> posts) {
    for (Post post : posts) {
      write(lineFor(post));
    }
  }

  private String lineFor(Post post) {
    return post.username() + " - " + post.message();
  }
}
