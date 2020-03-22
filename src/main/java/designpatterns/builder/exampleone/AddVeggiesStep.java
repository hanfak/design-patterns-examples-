package designpatterns.builder.exampleone;

public interface AddVeggiesStep {
  AddVeggiesStep addVeggie(final String vegetable);

  CloseStep close();
}
