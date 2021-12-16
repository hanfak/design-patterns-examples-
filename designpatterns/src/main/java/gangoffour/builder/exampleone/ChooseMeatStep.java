package gangoffour.builder.exampleone;

public interface ChooseMeatStep {
  ChooseCheeseStep withCheese(final String cheese);

  AddVeggiesStep noCheese();
}
