package designpatterns.separationofconcerns._01Example.none;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class WordSorter {
  public boolean loadProcessAndStore() throws IOException {
    Path path = Paths.get("src/main/resources/words.txt");

    List<String> words = Files.readAllLines(path).stream()
        .map(x -> Arrays.asList(x.split("-")))
        .flatMap(List::stream)
        .collect(toList());

    List<String> sorted = words.stream().sorted().collect(toList());

    try (FileWriter writer = new FileWriter("src/main/resources/sorted.txt")) {
      for (String word : sorted) {
        writer.write(word);
        writer.write("\n");
      }
      return true;
    }
  }

  public static void main(String[] args) throws IOException {
    new WordSorter().loadProcessAndStore();
  }
}
