package refactoring.legacy.goldenmaster.example1;

public class TexttestFixture {
  public static void main(String[] args) {
    System.out.println("OMGHAI!");
    // Set of random inputs, these cover all the test cases of the class (business rules)
    Item[] items = new Item[] {
        new Item("+5 Dexterity Vest", 10, 20), //
        new Item("Aged Brie", 2, 0), //
        new Item("Elixir of the Mongoose", 5, 7), //
        new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
        new Item("Sulfuras, Hand of Ragnaros", -1, 80),
        new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
    };
    // Inputs used in original class, to create the golden master
    GildedRose app = new GildedRose(items);

    int days = 2;
    if (args.length > 0) {
      days = Integer.parseInt(args[0]) + 1;
    }

    for (int i = 0; i < days; i++) {
      System.out.println("-------- day " + i + " --------");
      System.out.println("name, sellIn, quality");
      for (Item item : items) {
        // Can add to file if want to
        System.out.println(item); // Generates the golden msater results, used to compare with new ones
      }
      System.out.println();
      app.updateQuality();
    }
  }
}
