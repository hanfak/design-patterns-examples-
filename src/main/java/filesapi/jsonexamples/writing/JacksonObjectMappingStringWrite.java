package filesapi.jsonexamples.writing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import filesapi.domain.Person;

import java.io.IOException;
import java.io.StringWriter;

public class JacksonObjectMappingStringWrite {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        Person person = new Person("Stella", 23, false);

        //configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        StringWriter stringPerson = new StringWriter();

        try {
            objectMapper.writeValue(stringPerson, person);
            System.out.println("Person JSON is\n"+stringPerson);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
