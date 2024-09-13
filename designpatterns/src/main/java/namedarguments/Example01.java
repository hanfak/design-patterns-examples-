package namedarguments;

import lombok.Value;
import namedarguments.PunchArgs.PunchArgsBuilder;

import java.util.HashMap;
import java.util.Map;

import static namedarguments.Speed.speed;

public class Example01 {

  public static void main(String[] args) {
    Robot robot = new Robot();
    // Use plain args
    int punchAmount = robot.punch(2, 4);
    System.out.println("punchAmount = " + punchAmount);

    // Use helper methods
    int punchAmount1 = robot.punch(aSpeed(1), aForce(100));
    System.out.println("punchAmount1 = " + punchAmount1);

    // Use tiny types
    int punchAmount2 = robot.punch1(speed(1), Force.force(100));
    System.out.println("punchAmount2 = " + punchAmount2);

    // Use builder as argument, similar to just constructing the object via new or static factory
    int punchAmount3 = robot.punch2(PunchArgs.builder().force(1).speed(100));
    System.out.println("punchAmount3 = " + punchAmount3);

    // build with defaulted value for force
    int punchAmount3a = robot.punch2(PunchArgs.builder().speed(100));
    System.out.println("punchAmount3a = " + punchAmount3a);

    // Use map as arg
    int punchAmount4 = robot.punch3(Map.of(
        "speed", 1,
        "force", 100
    ));
    System.out.println("punchAmount4 = " + punchAmount4);

    Map<String, Integer> altArgs = new HashMap<>();
    altArgs.put("speed", 1);
    altArgs.put("force", 100);
    int punchAmount5 = robot.punch3(altArgs);
    System.out.println("punchAmount5 = " + punchAmount5);

    // Using object to wrap args, can use static factory method
    PunchArgs punchArgs = new PunchArgs(1, 100);
    int punchAmount6 = robot.punch4(punchArgs);
    System.out.println("punchAmount6 = " + punchAmount6);

    // Make the method a builder
    int punchAmount7 = robot.punchWithSpeed(1).withForce(100);
    System.out.println("punchAmount7 = " + punchAmount7);
    int punchAmount8 = robot.punch4(punchArgs);
    System.out.println("punchAmount8 = " + punchAmount8);
  }

  static int aForce(int i) {
    return i;
  }

  static int aSpeed(int i) {
    return i;
  }
}


class Robot {
  private int speed;

  public int punch(int speed, int force) {
    return speed * force;
  }

  public int punch1(Speed speed, Force force) {
    return speed.getValue() * force.getValue();
  }

  public int punch2(PunchArgsBuilder builder) {
    PunchArgs punchArgs = builder.build(); // Can move this step to method call
    return punchArgs.speed() * punchArgs.force();
  }

  public int punch3(Map<String, Integer> punchargs) {
    return punchargs.get("speed") * punchargs.get("force");
  }

  public int punch4(PunchArgs punchargs) {
    return punchargs.speed() * punchargs.force();
  }

  public Robot punchWithSpeed(int speed) {
    this.speed = speed;
    return this;
  }

  public int withForce(int force){
    return speed * force;
  }
}

record PunchArgs(int speed, Integer force) {


  public static PunchArgsBuilder builder() {
    return new PunchArgsBuilder();
  }

  public static class PunchArgsBuilder {

    private int speed;
    private Integer force;

    PunchArgsBuilder() {
    }

    public PunchArgsBuilder speed(int speed) {
      this.speed = speed;
      return this;
    }

    public PunchArgsBuilder force(Integer force) {
      this.force = force;
      return this;
    }

    public PunchArgs build() {
      return new PunchArgs(this.speed, this.force);
    }

    public String toString() {
      return "PunchArgs.PunchArgsBuilder(speed=" + this.speed + ", force=" + this.force + ")";
    }
  }
}

@Value
class Speed {
  int value;

  public static Speed speed(int value) {
    return new Speed(value);
  }
}

@Value
class Force {
  int value;

  public static Force force(int value) {
    return new Force(value);
  }
}