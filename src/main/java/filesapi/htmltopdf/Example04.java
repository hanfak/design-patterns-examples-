package filesapi.htmltopdf;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.exceptions.CssResolverException;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.net.FileRetrieve;
import com.itextpdf.tool.xml.net.FileRetrieveImpl;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.AbstractImageProvider;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Example04 {
  public static void main(String... args) throws IOException, DocumentException, CssResolverException {
    String filename = "Example_04_converted.pdf";
    if (Files.exists(Paths.get(filename))) {
      Files.delete(Paths.get(filename));
    }

    Document document = new Document();
    PdfWriter writer = PdfWriter.getInstance(document,
            new FileOutputStream(filename));

    document.open();

    HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
    htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
    htmlContext.setImageProvider(new AbstractImageProvider() {
      public String getImageRootPath() {
        return "./target/classes/";
      }
    });
    htmlContext.setLinkProvider(() -> "./target/classes/");
    // Not all css works
    CSSResolver cssResolver =
            XMLWorkerHelper.getInstance().getDefaultCssResolver(false);
    FileRetrieve retrieve = new FileRetrieveImpl("./target/classes/");
    cssResolver.setFileRetrieve(retrieve);

    PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
    HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
    CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);

    XMLWorker worker = new XMLWorker(css, true);
    XMLParser p = new XMLParser(worker);
    p.parse(new FileInputStream("target/classes/Example04.html"));
    document.close();
  }
}
