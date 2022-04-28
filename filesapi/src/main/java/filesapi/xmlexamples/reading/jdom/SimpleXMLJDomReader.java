package filesapi.xmlexamples.reading.jdom;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.File;
import java.io.IOException;

public class SimpleXMLJDomReader {

    public static void main(String[] args) {
        File file = new File("./src/main/resources/ExampleXml1.xml");

        SAXBuilder saxBuilder = new SAXBuilder();

        try {

            Document document = saxBuilder.build(file);
            Element classElement = document.getRootElement();

            System.out.println("Root element :" + classElement.getName());

            String city = classElement.getChild("city").getValue();
            System.out.println("city = " + city);

            String age = classElement.getChild("age").getValue();
            System.out.println("age = " + age);

            String male = classElement.getChild("male").getValue();
            System.out.println("male = " + male);

        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }

    }
}
