package decorator;

import lombok.Value;

@Value
public class InstructionTwo implements Instruction {
  int value;

  @Override
  public String instructionValue() {
    return "value = " + value;
  }
}
