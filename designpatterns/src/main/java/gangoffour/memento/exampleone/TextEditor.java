package gangoffour.memento.exampleone;

public class TextEditor {

  private final TextWindow textWindow;
  private TextWindowState savedTextWindow;

  public TextEditor(TextWindow textWindow) {
    this.textWindow = textWindow;
  }

  public void write(String text) {
    textWindow.addText(text);
  }

  public String print() {
    return textWindow.getCurrentText();
  }

  public void hitSave() {
    savedTextWindow = textWindow.save();
  }

  public void hitUndo() {
    textWindow.restore(savedTextWindow);
  }
}
