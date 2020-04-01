package designpatterns.builder.exampleone;

public interface ChooseCheeseStep {
  AddVeggiesStep addVeggie(final String vegetable);

  CloseStep noVeggies();
}