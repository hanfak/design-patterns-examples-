package designpatterns.separationofconcerns._01Example.complexities;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class WordSetter {
  // This can Accidental class can be passed in via the constructor
  // The method can take a location as the argument pass to the delegate if needs be
  public boolean loadProcessAndStore(Accidental accidental) throws IOException {
    List<String> sorted = sortWords(accidental.readWords());
    return accidental.storeWords(sorted);
  }

  private List<String> sortWords(List<String> words) {
    return words.stream().sorted().collect(toList());

  }

  public static void main(String[] args) throws IOException {
    new WordSetter().loadProcessAndStore(new Accidental() {
      @Override
      public List<String> readWords() throws IOException {
        Path path = Paths.get("src/main/resources/words.txt");

        return Files.readAllLines(path).stream()
            .map(x -> Arrays.asList(x.split("-")))
            .flatMap(List::stream)
            .collect(toList());
      }

      @Override
      public boolean storeWords(List<String> sorted) throws IOException {
        try (FileWriter writer = new FileWriter("src/main/resources/sorted1.txt")) {
          for (String word : sorted) {
            writer.write(word);
            writer.write("\n");
          }
          return true;
        }
      }
    });

  }
}


interface Accidental {
  List<String> readWords() throws IOException;

  boolean storeWords(List<String> sorted) throws IOException;
}

