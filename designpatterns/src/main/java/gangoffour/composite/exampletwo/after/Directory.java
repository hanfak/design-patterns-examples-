package gangoffour.composite.exampletwo.after;

import java.util.ArrayList;

import static gangoffour.composite.exampletwo.after.CompositeDemo.compositeBuilder;

public class Directory implements AbstractFile{
  private final String name;
  private final ArrayList includedFiles = new ArrayList();

  public Directory(String name) {
    this.name = name;
  }

  public void add(Object obj) {
    includedFiles.add(obj);
  }

  public void ls() {
    System.out.println(CompositeDemo.compositeBuilder + name);
    CompositeDemo.compositeBuilder.append("   ");
    for (Object includedFile : includedFiles) {
      // Leverage the "lowest common denominator"
      AbstractFile obj = (AbstractFile) includedFile;
      obj.ls();
    }
    CompositeDemo.compositeBuilder.setLength(CompositeDemo.compositeBuilder.length() - 3);
  }
}
