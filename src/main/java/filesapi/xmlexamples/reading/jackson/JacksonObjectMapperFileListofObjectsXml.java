package filesapi.xmlexamples.reading.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import filesapi.domain.Color;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

public class JacksonObjectMapperFileListofObjectsXml {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Path path = Paths.get("./src/main/resources/ExampleXml3.xml");

        try {
            // Much faster way of doing it
            List<Color> colors = Arrays.asList(objectMapper.readValue(Files.readAllBytes(path), Color[].class));
            List<Color> colors1 = objectMapper.readValue(Files.readAllBytes(path), new TypeReference<List<Color>>(){});

            colors.forEach(color -> System.out.println(output(color)));
            colors1.forEach(color -> System.out.println(output(color)));

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

