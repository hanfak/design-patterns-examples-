package gangoffour.composite.exampletwo.after;

import static gangoffour.composite.exampletwo.after.CompositeDemo.compositeBuilder;

public class File implements AbstractFile{
  private final String name;

  public File(String name) {
    this.name = name;
  }

  @Override
  public void ls() {
    System.out.println(compositeBuilder + name);
  }
}
