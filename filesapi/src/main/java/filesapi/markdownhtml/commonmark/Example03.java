package filesapi.markdownhtml.commonmark;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Set;

public class Example03 {
  public static void main(String... args) throws IOException {
    String content = new String(Files.readAllBytes(Paths.get("./target/classes/Example02.md")));


    Set<Extension> extensions = Collections.singleton(TablesExtension.create());
    HtmlRenderer renderer = HtmlRenderer.builder().extensions(extensions).build();
    Parser PARSER = Parser.builder().extensions(extensions).build();
    String htmlOutput = renderer.render(PARSER.parse(content));
    System.out.println("htmlOutput = \n\n" + htmlOutput);
    Document doc = Jsoup.parse(htmlOutput);

    Path path = Paths.get("Example_03_converted.html");
    try (BufferedWriter writer = Files.newBufferedWriter(path)) {
      writer.write(doc.toString());
    }
  }
}
