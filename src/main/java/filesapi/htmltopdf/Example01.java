package filesapi.htmltopdf;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlLoadOptions;

public class Example01 {
  public static void main(String... args) {
    // Paid service, has watermark
    HtmlLoadOptions htmloptions = new HtmlLoadOptions();
    Document doc = new Document("target/classes/Example01.html", htmloptions);
    doc.save("Example_01_converted.pdf");
  }
}
