package filesapi.markdownhtml.commonmark;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Example02 {
  public static void main(String... args) throws IOException {
    String content = new String(Files.readAllBytes(Paths.get("./target/classes/Example02.md")));


    Parser parser = Parser.builder().build();
    Node document = parser.parse(content);
    HtmlRenderer renderer = HtmlRenderer.builder().build();
    String htmlOutput = renderer.render(document);
    System.out.println("htmlOutput = \n\n" + htmlOutput);
    Document doc = Jsoup.parse(htmlOutput);

    Path path = Paths.get("Example_02_converted.html");
    try (BufferedWriter writer = Files.newBufferedWriter(path)) {
      writer.write(doc.toString());
    }
  }
}
