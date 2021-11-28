package designpatterns.gangoffour.builder.exampleone;

public interface ChooseBreadStep {
  ChooseMeatStep withMeat(final String meat);

  AddVeggiesStep vegan();
}
