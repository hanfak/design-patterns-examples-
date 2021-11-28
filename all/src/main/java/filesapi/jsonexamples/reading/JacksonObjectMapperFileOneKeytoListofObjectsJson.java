package filesapi.jsonexamples.reading;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import filesapi.domain.Color;
import filesapi.domain.Colors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.String.format;


public class JacksonObjectMapperFileOneKeytoListofObjectsJson {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Path path = Paths.get("./src/main/resources/ExampleJson4.json");

        try {

            Colors colors = objectMapper.readValue(Files.newInputStream(path), Colors.class);

            System.out.println(colors.getColors());
            colors.getColors().stream().forEach(color -> System.out.println(output(color)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String output(Color color) {
        return format("Object: %s, category: %s, color: %s, type: %s, code hex: %s, code rgba: %s",
                color.hashCode(),
                color.getCategory(),
                color.getColor(),
                color.getType(),
                color.getCode().getHex(),
                color.getCode().getRgba());
    }
}

