package enterprisepatterns.rulesengine.versiontwo.api;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Facts {

    private final Map<String, String> facts = new HashMap<>();

    public String getFact(String name) {
        return this.facts.get(name);
    }

    public void setFact(String name, String value) {
        this.facts.put(name, value);
    }

    public void setFactsFromFile(String path) {
        Path filePath = Paths.get(path);
        try(Stream<String> lines = Files.lines(filePath)) {
            String jsonDataSourceString = Files.readString(filePath);
            String jsonFacts = "$Facts[*].name"; // tODO not working
            DocumentContext jsonContext = JsonPath.parse(jsonDataSourceString);
            List<String> facts = jsonContext.read(jsonFacts);
            System.out.println("facts = " + facts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
