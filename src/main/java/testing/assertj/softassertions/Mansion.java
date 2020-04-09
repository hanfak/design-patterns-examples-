package testing.assertj.softassertions;

public class Mansion {
  private int guests = 6;
  private int revolverAmmo = 6;
  private String kitchen = "clean";
  private String library = "clean";
  private String candlestick = "pristine";
  private String colonel = "well kempt";
  private String professor = "well kempt";

  public void hostPotentiallyMurderousDinnerParty() {
    library = "messy";
    candlestick = "bent";
    professor = "bloodied and disheveled";
  }

  public int guests() {
    return guests;
  }

  public int revolverAmmo() {
    return revolverAmmo;
  }

  public String kitchen() {
    return kitchen;
  }

  public String library() {
    return library;
  }

  public String professor() {
    return professor;
  }

  public String colonel() {
    return colonel;
  }

  public String candlestick() {
    return candlestick;
  }
}
