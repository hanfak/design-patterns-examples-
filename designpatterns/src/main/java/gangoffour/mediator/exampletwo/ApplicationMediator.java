package gangoffour.mediator.exampletwo;

import java.util.ArrayList;

public class ApplicationMediator implements Mediator {
  private final ArrayList<Colleague> colleagues;

  public ApplicationMediator() {
    colleagues = new ArrayList<>();
  }

  public void addColleague(Colleague colleague) {
    colleagues.add(colleague);
  }

  public void send(String message, Colleague originator) {
    //let all other screens know that this screen has changed
    for (Colleague colleague : colleagues) {
      //don't tell ourselves
      if (colleague != originator) {
        colleague.receive(message);
      }
    }
  }
}
