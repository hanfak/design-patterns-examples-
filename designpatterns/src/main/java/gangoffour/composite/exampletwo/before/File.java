package gangoffour.composite.exampletwo.before;

public class File {
  private final String name;

  public File(String name) {
    this.name = name;
  }

  public void ls() {
    System.out.println(CompositeDemo.compositeBuilder + name);
  }
}
