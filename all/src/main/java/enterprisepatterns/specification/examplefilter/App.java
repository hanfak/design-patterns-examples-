package enterprisepatterns.specification.examplefilter;

import enterprisepatterns.specification.examplefilter.creature.*;
import enterprisepatterns.specification.examplefilter.property.Mass;
import enterprisepatterns.specification.examplefilter.property.Movement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static enterprisepatterns.specification.examplefilter.property.Color.DARK;
import static enterprisepatterns.specification.examplefilter.property.Color.RED;
import static enterprisepatterns.specification.examplefilter.property.Movement.FLYING;
import static enterprisepatterns.specification.examplefilter.property.Movement.SWIMMING;
import static java.util.function.Predicate.not;

public class App {
  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  public static void main(String... args) {

    var creatures = List.of(
            new Goblin(),
            new Octopus(),
            new Dragon(),
            new Shark(),
            new Troll(),
            new KillerBee()
    );

    // so-called "hard-coded" specification
    LOGGER.info("Demonstrating hard-coded specification :");
    // find all walking creatures
    LOGGER.info("Find all walking creatures");
    print(creatures, creature -> Movement.WALKING.equals(creature.getMovement()));
    // find all dark creatures
    LOGGER.info("Find all dark creatures");
    print(creatures, creature -> DARK.equals(creature.getColor()));
    LOGGER.info("\n");

    // so-called "parameterized" specification
    LOGGER.info("Demonstrating parameterized specification :");
    // find all creatures heavier than 500kg
    LOGGER.info("Find all creatures heavier than 600kg");
    print(creatures, creature -> creature.getMass().greaterThan(new Mass(600.0)));
    // find all creatures heavier than 500kg
    LOGGER.info("Find all creatures lighter than or weighing exactly 500kg");
    print(creatures, creature -> creature.getMass().smallerThanOrEq(new Mass(600.0)));
    LOGGER.info("\n");


    // so-called "composite" specification
    LOGGER.info("Demonstrating composite specification :");
    // find all red and flying creatures
    LOGGER.info("Find all red and flying creatures");
    Predicate<AbstractCreature> colourIsRed = creature -> creature.getColor().equals(RED);
    Predicate<AbstractCreature> isFlying = creature -> creature.getMovement().equals(FLYING);
    creatures.stream()
            .filter(colourIsRed.and(isFlying))
            //.map(transfortmation lambda) all those who passed the specifcation can do something on it
            .map(Objects::toString)
            .forEach(LOGGER::info);

    // find all creatures dark or red, non-swimming, and heavier than or equal to 400kg
    LOGGER.info("Find all scary creatures");
    Predicate<AbstractCreature> colourIsDark = creature -> creature.getColor().equals(DARK);
    Predicate<AbstractCreature> isSwimming = creature -> creature.getMovement().equals(SWIMMING);
    Predicate<AbstractCreature> isMassGreaterThan400 = creature -> creature.getMass().greaterThan(new Mass(400.0));
    Predicate<AbstractCreature> isMassEqualTo400 = creature -> creature.getMass().equals(new Mass(400.0));

    creatures.stream()
            .filter(colourIsDark.or(colourIsRed)
                    .and(not(isSwimming))
                    .and(isMassGreaterThan400.or(isMassEqualTo400)))
            .map(Objects::toString)
            .forEach(LOGGER::info);
    System.out.println();
    System.out.println();
  }

  private static void print(List<AbstractCreature> creatures, Predicate<Creature> selector) {
    creatures.stream().filter(selector).map(Objects::toString).forEach(LOGGER::info);
  }

}
