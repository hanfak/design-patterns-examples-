package filesapi.markdownhtml.commonmark;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class Example01 {
  public static void main(String... args) {
    Parser parser = Parser.builder().build();
    Node document = parser.parse("This is *Sparta*");
    HtmlRenderer renderer = HtmlRenderer.builder().build();
    String htmlOutput = renderer.render(document);
    System.out.println("htmlOtuput = \n\n" + htmlOutput);
  }
}
