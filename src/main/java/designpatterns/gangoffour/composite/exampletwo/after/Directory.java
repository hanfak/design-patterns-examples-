package designpatterns.gangoffour.composite.exampletwo.after;


import java.util.ArrayList;

import static designpatterns.gangoffour.composite.exampletwo.after.CompositeDemo.compositeBuilder;


public class Directory implements AbstractFile{
  private String name;
  private ArrayList<AbstractFile> includedFiles = new ArrayList();

  public Directory(String name) {
    this.name = name;
  }

  public void add(Directory obj) {
    includedFiles.add(obj);
  }

  @Override
  public void ls() {
    System.out.println(compositeBuilder + name);
    compositeBuilder.append("   ");
    for (AbstractFile abstractFile : includedFiles) {
      // Recover the type of this object
      String name = abstractFile.getClass().getSimpleName();
      if (name.equals("Directory")) {
        ((Directory)abstractFile).ls();
      } else {
        ((File)abstractFile).ls();
      }
    }
    compositeBuilder.setLength(compositeBuilder.length() - 3);
  }
}
