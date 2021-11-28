package filesapi.xmlexamples.writing.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import filesapi.domain.Address;
import filesapi.domain.Employee;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JacksonObjectMappingComplexFileWrite {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new XmlMapper();

        Employee emp1 = createEmployee();

        //configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        try {
            objectMapper.writeValue(new FileOutputStream("./src/main/resources/output-2.xml"), emp1);
//            objectMapper.writeValue(new File("output-2.xml"), emp1); // Alternative


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Employee createEmployee() {

        Employee employee = new Employee();
        employee.setId(100);
        employee.setName("David");
        employee.setPermanent(false);
        employee.setPhoneNumbers(new long[] { 123456, 987654 });
        employee.setRole("Manager");

        Address address = new Address();
        address.setCity("Bangalore");
        address.setStreet("BTM 1st Stage");
        address.setZipcode(560100);
        employee.setAddress(address);

        List<String> cities = new ArrayList<>();
        cities.add("Los Angeles");
        cities.add("New York");
        employee.setCities(cities);

        Map<String, String> properties = new HashMap<>();
        properties.put("salary", "1000 Rs");
        properties.put("age", "28 years");
        employee.setProperties(properties);

        return employee;
    }

}
