package filesapi.jsonexamples.reading;

import com.fasterxml.jackson.databind.ObjectMapper;
import filesapi.domain.Person;

import java.io.IOException;

public class JacksonObjectMapperString {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        String personJson =
                "{ \"name\" : \"John\", \"age\" : 5, \"male\" : true }";

        // Need an empty default constructor set. if a constructor has already been set
        // Does not need getter or setters
        try {
            Person person = objectMapper.readValue(personJson, Person.class);

            System.out.println("person name = " + person.name);
            System.out.println("person age = " + person.age);
            System.out.println("person is male is " + person.male);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

