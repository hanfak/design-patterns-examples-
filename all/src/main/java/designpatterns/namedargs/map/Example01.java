package designpatterns.namedargs.map;

import lombok.Builder;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;

import static designpatterns.namedargs.map.Force.force;
import static designpatterns.namedargs.map.Speed.speed;

public class Example01 {

  public static void main(String[] args) {
    Robot robot = new Robot();
    // Use plain args
    int punchAmount = robot.punch(2, 4);
    System.out.println("punchAmount = " + punchAmount);

    // Use helper methods
    int punchAmount1 = robot.punch(aspeed(1), aforce(100));
    System.out.println("punchAmount1 = " + punchAmount1);

    // Use tiny types
    int punchAmount2 = robot.punch1(speed(1), force(100));
    System.out.println("punchAmount2 = " + punchAmount2);

    // Use builder as argument, similar to just constructing the object via new or static factory
    int punchAmount3 = robot.punch2(PunchArgs.punchArgs().force(1).speed(100));
    System.out.println("punchAmount3 = " + punchAmount3);

    // build with defaulted value for force
    int punchAmount3a = robot.punch2(PunchArgs.punchArgs().speed(100));
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
    int punchAmuont5 = robot.punch3(altArgs);
    System.out.println("punchAmuont5 = " + punchAmuont5);

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

  static int aforce(int i) {
    return i;
  }

  static int aspeed(int i) {
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

  public int punch2(PunchArgs.PunchArgsBuilder builder) {
    PunchArgs punchArgs = builder.build(); // Can move this step to method call
    return punchArgs.getSpeed() * punchArgs.getForce();
  }

  public int punch3(Map<String, Integer> punchargs) {
    return punchargs.get("speed") * punchargs.get("force");
  }

  public int punch4(PunchArgs punchargs) {
    return punchargs.getSpeed() * punchargs.getForce();
  }

  public Robot punchWithSpeed(int speed) {
    this.speed = speed;
    return this;
  }

  public int withForce(int force){
    return speed * force;
  }
}

@Builder(builderMethodName = "punchArgs")
@Value
class PunchArgs {
  int speed;
  @Builder.Default  Integer force = 1;
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