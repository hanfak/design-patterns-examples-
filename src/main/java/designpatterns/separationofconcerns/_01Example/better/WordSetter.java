package designpatterns.separationofconcerns._01Example.better;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class WordSetter {

  private final WordListener wordListener;
  private final WordSource wordSource;

  public WordSetter(WordListener wordListener, WordSource wordSource) {
    this.wordListener = wordListener;
    this.wordSource = wordSource;
  }

  public void loadProcessAndStore() throws IOException {
    List<String> sorted = sortWords(wordSource.readWords());
    wordListener.onWordsChanged(sorted);
  }

  private List<String> sortWords(List<String> words) {
    return words.stream().sorted().collect(toList());
  }

  public static void main(String[] args) throws IOException {
    new WordSetter(sorted -> {
      try (FileWriter writer = new FileWriter("src/main/resources/sorted1.txt")) {
        for (String word : sorted) {
          writer.write(word);
          writer.write("\n");
        }
      } catch (Exception e) {
        throw new RuntimeException();
      }
    }, () -> {
      Path path = Paths.get("src/main/resources/words.txt");

      return Files.readAllLines(path).stream()
          .map(x -> Arrays.asList(x.split("-")))
          .flatMap(List::stream)
          .collect(toList());
    }).loadProcessAndStore();
  }
}

interface WordSource {
  List<String> readWords() throws IOException;
}

interface WordListener {
  void onWordsChanged(List<String> sorted);
}

