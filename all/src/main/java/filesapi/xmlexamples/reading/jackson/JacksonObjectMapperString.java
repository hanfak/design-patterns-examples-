package filesapi.xmlexamples.reading.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import filesapi.domain.Person;

import java.io.IOException;

public class JacksonObjectMapperString {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new XmlMapper();

        String personXml =
                "<root>\n" +
                "   <age>5</age>\n" +
                "   <male>true</male>\n" +
                "   <name>John</name>\n" +
                "</root>";

        // Need an empty default constructor set. if a constructor has already been set
        // Does not need getter or setters
        try {
            Person person = objectMapper.readValue(personXml, Person.class);

            System.out.println("person name = " + person.name);
            System.out.println("person age = " + person.age);
            System.out.println("person is male is " + person.male);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

