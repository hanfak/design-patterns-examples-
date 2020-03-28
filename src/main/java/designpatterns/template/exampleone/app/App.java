package designpatterns.template.exampleone.app;

import designpatterns.template.exampleone.model.Computer;
import designpatterns.template.exampleone.model.ComputerBuilder;
import designpatterns.template.exampleone.model.HighEndComputerBuilder;
import designpatterns.template.exampleone.model.StandardComputerBuilder;

public class App {
  public static void main(String[] args) {
    ComputerBuilder standardComputerBuilder = new StandardComputerBuilder();
    Computer standardComputer = standardComputerBuilder.buildComputer();
    standardComputer.getComputerParts()
            .forEach((k, v) -> System.out.println("Part : " + k + " - Value : " + v));

    ComputerBuilder highEndComputerBuilder = new HighEndComputerBuilder();
    Computer highEndComputer = highEndComputerBuilder.buildComputer();
    highEndComputer.getComputerParts()
            .forEach((k, v) -> System.out.println("Part : " + k + " - Value : " + v));
  }
}
