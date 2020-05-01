package javalibraries.email.exampleone;

import com.icegreen.greenmail.util.GreenMail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.HashSet;
import java.util.Set;

import static com.google.code.tempusfugit.temporal.Duration.seconds;
import static com.google.code.tempusfugit.temporal.Timeout.timeout;
import static com.google.code.tempusfugit.temporal.WaitFor.waitOrTimeout;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JavaMailSenderTest {
  private GreenMail greenMail;
  private String subject = "This is a test";
  private String text = "Hello world @ " + System.currentTimeMillis();
  private String recipient = "to@localhost.com";
  private String from = "helo@hello.com";
  private String contentType = "text/plain";

  private EmailSender javaMailSender;

  public JavaMailSenderTest() {
    javaMailSender = new JavaMailSender();
  }

  @Before
  public void startMailServer() {
    greenMail = new GreenMail();
    greenMail.start();
  }

  @After
  public void stopMailServer() {
    greenMail.stop();
  }

  @Test
  public void canSendEmail() throws Exception {
    EmailMessage emailMessage = new EmailMessage(asSet(recipient), from, subject, text, contentType);

    javaMailSender.sendMessage("localhost", 3025, emailMessage, RuntimeException::new);

    waitOrTimeout(() -> greenMail.getReceivedMessages().length == 1,  timeout(seconds(10)));

    MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
    MimeMessage receivedMessage = receivedMessages[0];

    Address actualRecipient = receivedMessage.getAllRecipients()[0];
    assertThat(((InternetAddress) actualRecipient).getAddress(), is(recipient));
    assertThat(((String) receivedMessage.getContent()).trim(), is(text));
    assertThat(receivedMessage.getContentType(), containsString(contentType));
    assertThat(receivedMessage.getSubject(), is(subject));

    Address fromAddress = receivedMessage.getFrom()[0];
    assertThat(((InternetAddress) fromAddress).getAddress(), is(from));
  }


  private Set<String> asSet(final String recipient) {
    return new HashSet<>() {{
      add(recipient);
    }};
  }
}