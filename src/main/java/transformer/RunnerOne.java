package transformer;

public class RunnerOne {
  // We want to change the data that was extracted, and want to transform it before passing it on
  private Extractor extractor;

  public RunnerOne(Extractor extractor) {
    this.extractor = extractor;
  }

  public static void main(String... args) {
    RunnerOne runnerOne = new RunnerOne(new Extractor());

    String extractedInput1 = runnerOne.extractor.extract("Hello");
    String extractedInput2 = runnerOne.extractor.extract("Java");
    String extractedInput3 = runnerOne.extractor.extract("Bang!");
    System.out.println(transformInput(extractedInput1));
    System.out.println(transformInput(extractedInput2));
    System.out.println(transformInput(extractedInput3));

  }

  // Does the job, but starts getting bloated the more cases we have
  private static String transformInput(String input) {
    if (input.equals("Hello")) {
      return "HELLO";
    }

    if (input.equals("Bang!")) {
      return "B4NG!";
    }
    return input;
  }

}
