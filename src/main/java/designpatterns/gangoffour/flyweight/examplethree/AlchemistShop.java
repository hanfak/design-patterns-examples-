package designpatterns.gangoffour.flyweight.examplethree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * AlchemistShop holds potions on its shelves. It uses PotionFactory to provide the potions.
 */
public class AlchemistShop {

  private static final Logger LOGGER = LoggerFactory.getLogger(AlchemistShop.class);

  private List<Potion> topShelf;
  private List<Potion> bottomShelf;

  public AlchemistShop() {
    var factory = new PotionFactory();
    topShelf = List.of(
            factory.createPotion(PotionType.INVISIBILITY),
            factory.createPotion(PotionType.INVISIBILITY),
            factory.createPotion(PotionType.STRENGTH),
            factory.createPotion(PotionType.HEALING),
            factory.createPotion(PotionType.INVISIBILITY),
            factory.createPotion(PotionType.STRENGTH),
            factory.createPotion(PotionType.HEALING),
            factory.createPotion(PotionType.HEALING)
    );
    bottomShelf = List.of(
            factory.createPotion(PotionType.POISON),
            factory.createPotion(PotionType.POISON),
            factory.createPotion(PotionType.POISON),
            factory.createPotion(PotionType.HOLY_WATER),
            factory.createPotion(PotionType.HOLY_WATER)
    );
  }

  public final List<Potion> getTopShelf() {
    return List.copyOf(this.topShelf);
  }

  public final List<Potion> getBottomShelf() {
    return List.copyOf(this.bottomShelf);
  }

  public void enumerate() {
    System.out.println();
    LOGGER.info("Enumerating top shelf potions\n");
    topShelf.forEach(Potion::drink);
    System.out.println();
    LOGGER.info("Enumerating bottom shelf potions\n");
    bottomShelf.forEach(Potion::drink);
  }
}
