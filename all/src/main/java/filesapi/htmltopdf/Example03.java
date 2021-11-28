package filesapi.htmltopdf;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.AbstractImageProvider;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Example03 {
  public static void main(String... args) throws IOException, DocumentException {
    String filename = "Example_03_converted.pdf";
    if (Files.exists(Paths.get(filename))) {
      Files.delete(Paths.get(filename));
    }

    Document document = new Document();
    PdfWriter writer = PdfWriter.getInstance(document,
            new FileOutputStream(filename));


    HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
    htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
    htmlContext.setImageProvider(new AbstractImageProvider() {
      public String getImageRootPath() {
        return "./target/classes/";
      }
    });
//    htmlContext.setLinkProvider(() -> "./target/classes/");
    PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
    HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
    document.open();

    XMLWorker worker = new XMLWorker(html, true);
    XMLParser p = new XMLParser(worker);
    p.parse(new FileInputStream("target/classes/Example03.html"));
    document.close();
  }
}
