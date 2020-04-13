package designpatterns.gangoffour.builder.exampleone;

import java.util.ArrayList;
import java.util.List;

public class SandwichBuilder implements ChooseBreadStep, ChooseMeatStep, ChooseCheeseStep, AddVeggiesStep, CloseStep {

  final String bread;
  String meat;
  String cheese;

  final List<String> vegetables = new ArrayList<>();

  public SandwichBuilder(String bread) {
    this.bread = bread;
  }

  @Override
  public ChooseMeatStep withMeat(String meat) {
    this.meat = meat;
    return this;
  }

  @Override
  public AddVeggiesStep vegan() {
    return this;
  }

  @Override
  public ChooseCheeseStep withCheese(String cheese) {
    this.cheese = cheese;
    return this;
  }

  @Override
  public AddVeggiesStep noCheese() {
    return this;
  }

  @Override
  public AddVeggiesStep addVeggie(String vegetable) {
    this.vegetables.add(vegetable);
    return this;
  }

  @Override
  public CloseStep noVeggies() {
    return this;
  }

  @Override
  public CloseStep close() {
    return this;
  }

  @Override
  public Sandwich create() {
    return new Sandwich(this.bread, this.meat, this.cheese, this.vegetables);
  }
}