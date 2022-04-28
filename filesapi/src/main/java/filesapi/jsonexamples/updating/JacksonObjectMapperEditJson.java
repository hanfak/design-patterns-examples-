package filesapi.jsonexamples.updating;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JacksonObjectMapperEditJson {
    public static void main(String[] args) throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get("./src/main/resources/ExampleJson2.json"));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        //create JsonNode
        JsonNode rootNode = objectMapper.readTree(jsonData);

        //update JSON data by using the same key to overwrite
        ((ObjectNode) rootNode).put("id", 500);

        //add new key value
        ((ObjectNode) rootNode).put("test", "test value");

        //Update map/json object within key
        JsonNode addressNode = rootNode.path("address");
        ((ObjectNode) addressNode).put("city", "London");
        ((ObjectNode) addressNode).put("country", "UK"); // Add
        ((ObjectNode) addressNode).remove("zipcode"); // Remove

        // Array
        ArrayNode gamesNode = objectMapper.createArrayNode();

        ObjectNode game1 = objectMapper.createObjectNode();
        game1.put("a", 1);
        game1.put("b", 2);
        ObjectNode game2 = objectMapper.createObjectNode();
        game2.put("c", 1);
        game2.put("d", 2);
        gamesNode.add(game1);
        gamesNode.add(game2);
        ((ObjectNode) rootNode).set("games", gamesNode);

        ArrayNode numberNode = objectMapper.createArrayNode();
        numberNode.add(1);
        numberNode.add(2);
        ((ObjectNode) rootNode).set("numbers", numberNode);

        // Json object
        JsonNode emailNode = objectMapper.createObjectNode();
        ((ObjectNode) emailNode).put("home", "a@home.com");
        ((ObjectNode) emailNode).put("work", "a@work.com");
        ((ObjectNode) rootNode).set("email", emailNode);


        //Edit/update array by replacing whole array, getting elements to keep, and replacing others
        JsonNode phoneNumbers = rootNode.get("phoneNumbers");
        System.out.println(phoneNumbers.get(1));
        System.out.println(phoneNumbers);
        ArrayNode phoneNode = objectMapper.createArrayNode();
        // Can change the order they were set in
        phoneNode.add(888888888);
        phoneNode.add(phoneNumbers.get(0)); // keep element
        ((ObjectNode) rootNode).set("phoneNumbers", phoneNode);

        //remove existing key
        ((ObjectNode) rootNode).remove("role");
        ((ObjectNode) rootNode).remove("properties");

        try {
            objectMapper.writeValue(new File("./src/main/resources/updated_emp.json"), rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
