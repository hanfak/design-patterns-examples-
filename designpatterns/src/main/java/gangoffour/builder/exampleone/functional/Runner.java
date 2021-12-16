package gangoffour.builder.exampleone.functional;


import gangoffour.builder.exampleone.Sandwich;

public class Runner {
  public static void main(String[] args) {

    Sandwich sandwichOne = Sandwich.make("white", sandwichConfig -> sandwichConfig
                                                          .withMeat("parma")
                                                          .withCheese("cheedar")
                                                          .addVeggie("salad")
                                                          .close()
    );
    System.out.println("sandwichOne = " + sandwichOne);

    Sandwich sandwichTwo = Sandwich.make("brown", sandwichConfig -> sandwichConfig
                                                              .withMeat("salami")
                                                              .noCheese()
                                                              .close()
    );
    System.out.println("sandwichTwo = " + sandwichTwo);

    Sandwich sandwichThree = Sandwich.make("spelt", sandwichConfig -> sandwichConfig
                                                              .vegan()
                                                              .addVeggie("salad")
                                                              .addVeggie("gherkins")
                                                              .addVeggie("tomatoes")
                                                              .close()
    );
    System.out.println("sandwichThree = " + sandwichThree);
  }


}


