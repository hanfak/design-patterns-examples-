package caseswitchrefactor.example2.newversion;

public class Formatter {
  private Service service;

  public Formatter(Service service) {
    this.service = service;
  }

  public String doTheJob(String theInput) {
    Response response = service.askForPermission();
    return response.format("%s%s", theInput);
  }
}

interface Service {
  Response askForPermission();
}

enum Response {
  FAIL {
    @Override
    public String format(String template, String input) {
      return "error";
    }
  }, OK {
    @Override
    public String format(String template, String input) {
      return String.format(template, input, input);
    }
  };

  public abstract String format(String template, String input);


}