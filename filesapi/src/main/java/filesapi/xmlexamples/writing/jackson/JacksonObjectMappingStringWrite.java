package filesapi.xmlexamples.writing.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import filesapi.domain.Person;

import java.io.IOException;
import java.io.StringWriter;

public class JacksonObjectMappingStringWrite {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new XmlMapper();

        Person person = new Person("Stella", 23, false);

        //configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        StringWriter stringPerson = new StringWriter();

        try {
            objectMapper.writeValue(stringPerson, person);
            System.out.println("Person XML is\n" + stringPerson);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
