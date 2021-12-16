package gangoffour.template.exampleone.app;

import gangoffour.template.exampleone.model.Computer;
import gangoffour.template.exampleone.model.ComputerBuilder;
import gangoffour.template.exampleone.model.HighEndComputerBuilder;
import gangoffour.template.exampleone.model.StandardComputerBuilder;

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
