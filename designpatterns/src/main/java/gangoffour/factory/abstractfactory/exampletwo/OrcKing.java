package gangoffour.factory.abstractfactory.exampletwo;

public class OrcKing implements King {

  static final String DESCRIPTION = "This is the Orc king!";

  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}
