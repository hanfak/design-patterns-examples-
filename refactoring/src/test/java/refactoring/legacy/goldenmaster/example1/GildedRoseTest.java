package refactoring.legacy.goldenmaster.example1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class GildedRoseTest {
  public static final String NUMBER_OF_DAYS = "10";

  @Test
  public void bar() {
    // Controls the console, so that we can capture the output to compare
    ByteArrayOutputStream originalConsole = new ByteArrayOutputStream();
    System.setOut(new PrintStream(originalConsole));
    TexttestFixture.main(new String[]{NUMBER_OF_DAYS});

    ByteArrayOutputStream refactorConsole = new ByteArrayOutputStream();
    System.setOut(new PrintStream(refactorConsole));
    mockMain(new String[]{NUMBER_OF_DAYS});

    // checks the orignal golden master, with changes to new class under test
    // Can use <click to see difference> to compare the two outputs
    assertEquals(originalConsole.toString(), refactorConsole.toString());
  }

  // Does the same as TesttestFixture but for the new class that will be refactored
  void mockMain(String[] args) {
    System.out.println("OMGHAI!");

    // Important that both use the same inputs
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

    GildedRoseRefactored app = new GildedRoseRefactored(items);

    int days = 2;
    if (args.length > 0) {
      days = Integer.parseInt(args[0]) + 1;
    }

    for (int i = 0; i < days; i++) {
      System.out.println("-------- day " + i + " --------");
      System.out.println("name, sellIn, quality");
      for (Item item : items) {
        System.out.println(item);
      }
      System.out.println();
      app.updateQuality();
    }
  }
}