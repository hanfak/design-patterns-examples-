package filesapi.htmltopdf;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example02 {
  public static void main(String... args) throws IOException, DocumentException {
    Document document = new Document();
    PdfWriter writer = PdfWriter.getInstance(document,
            new FileOutputStream("Example_02_converted.pdf"));
    document.open();
    XMLWorkerHelper.getInstance().parseXHtml(writer, document,
            new FileInputStream("target/classes/Example01.html"));
    document.close();
  }
}
