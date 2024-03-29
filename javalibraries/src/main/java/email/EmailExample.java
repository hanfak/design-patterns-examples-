package email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

import static javax.mail.Message.RecipientType.TO;

//https://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
public class EmailExample {
  public static void main(String... args) {
    final String username = "fakira.work@gmail.com";
    final String password = "qoeknvvwgglrfbyl";

    Properties prop = new Properties();
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "587");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true"); //TLS

    Session session = Session.getInstance(prop,
            new javax.mail.Authenticator() {
              protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
              }
            });
    try {

      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("from@gmail.com"));
      message.setRecipients(TO, InternetAddress.parse(username));
      message.setSubject("Testing Gmail TLS");
      message.setText("Dear Mail Crawler,"
              + "\n\n Please do not spam my javalibraries.email!");

      Transport.send(message);

      System.out.println("Done");

    } catch (MessagingException e) {
      e.printStackTrace();
    }

  }


}
