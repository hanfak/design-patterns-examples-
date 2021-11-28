package filesapi.jsonexamples.reading;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import filesapi.domain.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class JacksonObjectMapperFileComplexJson {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        Path path = Paths.get("./src/main/resources/ExampleJson2.json");

        try {
            System.out.println("Using inputstream from path");
            Employee employee = objectMapper.readValue(Files.newInputStream(path), Employee.class);

            System.out.println("employee name = " + employee.getName());
            System.out.println("employee is permanent = " + employee.isPermanent());
            System.out.println("employee is cities = " + employee.getCities());
            System.out.println("employee is cities, first city = ");
            System.out.println(employee.getCities().get(0));

            System.out.println("employee phone numbers are  ");
            Arrays.stream(employee.getPhoneNumbers()).forEach(System.out::println);
            System.out.println("employee properties are  " + employee.getProperties());
            System.out.println("employee properties age is  " + employee.getProperties().get("age"));
            System.out.println("employee properties salary is  " + employee.getProperties().get("salary"));
            System.out.println("employee address city is  " + employee.getAddress().getCity());
            System.out.println("employee address is  " + employee.getAddress());
            System.out.println(employee.getRole());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

