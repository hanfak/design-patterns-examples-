package transformer;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RunnerTwo {
  private Extractor extractor;

  public RunnerTwo(Extractor extractor) {
    this.extractor = extractor;
  }

  public static void main(String... args) {
    RunnerTwo runner = new RunnerTwo(new Extractor());

    String extractedInput1 = runner.extractor.extract("ONNET-MPF");
    String extractedInput2 = runner.extractor.extract("FTTP-TALKTALK");
    String extractedInput3 = runner.extractor.extract("CABLE");

    System.out.println("Example which will throw exception if input is not in resource");
    ResourceName resourceName1 = ResourceName.fromApiName(extractedInput1);
    System.out.println(resourceName1);
    System.out.println(resourceName1.changeData());

    ResourceName resourceName2 = ResourceName.fromApiName(extractedInput2);
    System.out.println(resourceName2);
    System.out.println(resourceName2.changeData());

    try {
      ResourceName resourceName3 = ResourceName.fromApiName(extractedInput3);
      System.out.println(resourceName3);
      System.out.println(resourceName3.changeData());
    } catch (Exception e) {
      System.out.println("Issue with this: " + e);
    }

    System.out.println("\nNext example using Optionals");
    List<String> inputs = Arrays.asList(extractedInput1, extractedInput2, extractedInput3);

    for (String input : inputs) {
      Optional<ResourceName> resource = ResourceName.fromApiNameV2(input);
      System.out.println(resource.map(ResourceName::changeData).orElse(input));
    }
  }
}
