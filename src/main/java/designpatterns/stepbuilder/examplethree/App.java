package designpatterns.stepbuilder.examplethree;

public class App {
  public static void main(String... args) {
    Email email = Email.builder().from("Microservices Weekly <mw@microservicesweekly.com>")
            .to("svlada@gmail.com")
            .subject("Subject")
            .content("Test email")
            .build();
    System.out.println("email = " + email);
  }
}
