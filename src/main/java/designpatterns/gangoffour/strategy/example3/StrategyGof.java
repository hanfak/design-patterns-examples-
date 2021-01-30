package designpatterns.gangoffour.strategy.example3;

public class StrategyGof {

  interface TextFormatter {
    boolean filter(String text);

    String format(String text);
  }

  public static class PlainTextFormatter implements TextFormatter {

    @Override
    public boolean filter(String text) {
      return true;

    }

    @Override
    public String format(String text) {
      return text;
    }
  }

  public static class ErrorTextFormatter implements TextFormatter {

    @Override
    public boolean filter(String text) {
      return text.startsWith("ERROR");

    }

    @Override
    public String format(String text) {
      return text.toUpperCase();
    }
  }

  public static class ShortTextFormatter implements TextFormatter {

    @Override
    public boolean filter(String text) {
      return text.length() < 20;

    }

    @Override
    public String format(String text) {
      return text.toLowerCase();
    }
  }

  public static class TextEditor {
    private final TextFormatter textFormatter;

    public TextEditor(TextFormatter textFormatter) {
      this.textFormatter = textFormatter;
    }

    public void publishText(String text) {
      if (textFormatter.filter(text)) {
        System.out.println(textFormatter.format(text));
      }
    }
  }

  public static void main(String[] args) {
    TextEditor textEditor = new TextEditor(new ErrorTextFormatter());
    textEditor.publishText("ERROR - something bad happened");
    textEditor.publishText("DEBUG - I'm here");
    System.out.println("---");
    TextEditor textEditor1 = new TextEditor(new PlainTextFormatter());
    textEditor1.publishText("ERROR - something bad happened");
    textEditor1.publishText("DEBUG - I'm here");
    System.out.println("---");
    TextEditor textEditor2 = new TextEditor(new ShortTextFormatter());
    textEditor2.publishText("ERROR - something bad happened");
    textEditor2.publishText("DEBUG - I'm here");
  }
}

