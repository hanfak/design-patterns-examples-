package caching.decorator;

import lombok.Value;

@Value
public class InstructionOne implements Instruction {
  String value;

  @Override
  public String instructionValue() {
    return "value = " + value;
  }
}
