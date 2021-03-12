package filesapi.xmlexamples.reading.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import filesapi.domain.PersonOne;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JacksonObjectMapperFileSimpleXml {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new XmlMapper();

        File file = new File("./src/main/resources/ExampleXml1.xml");
        Path path = Paths.get("./src/main/resources/ExampleXml1.xml");

        // Need to have getters and setters in class that is being created
        try {
            System.out.println("Using file");
            PersonOne person = objectMapper.readValue(file, PersonOne.class);

            System.out.println("person name = " + person.getName());
            System.out.println("person age = " + person.getAge());
            System.out.println("person is male is " + person.getMale());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        try {
            System.out.println("Using inputstream from path");
            PersonOne person = objectMapper.readValue(Files.newInputStream(path), PersonOne.class);

            System.out.println("person name = " + person.getName());
            System.out.println("person age = " + person.getAge());
            System.out.println("person is male is " + person.getMale());

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        try {
            System.out.println("Using bytes as input from path");
            PersonOne person = objectMapper.readValue(Files.readAllBytes(path), PersonOne.class);

            System.out.println("person name = " + person.getName());
            System.out.println("person age = " + person.getAge());
            System.out.println("person is male is " + person.getMale());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

