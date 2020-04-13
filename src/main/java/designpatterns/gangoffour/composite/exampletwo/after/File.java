package designpatterns.gangoffour.composite.exampletwo.after;

import static designpatterns.gangoffour.composite.exampletwo.after.CompositeDemo.compositeBuilder;

public class File implements AbstractFile{
  private String name;

  public File(String name) {
    this.name = name;
  }

  @Override
  public void ls() {
    System.out.println(compositeBuilder + name);
  }
}
