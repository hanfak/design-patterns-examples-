package javalibraries.email.exampleone;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMailSender implements EmailSender {
    public void sendMessage(String host, Integer port, EmailMessage emailMessage, EmailExceptionHandler emailExceptionHandler) {
        Properties props = new Properties();
        props.setProperty("mail.host", host);
        props.setProperty("mail.smtp.port", port.toString());

        Session session = Session.getDefaultInstance(props, null);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailMessage.getFrom()));

            for (String toAddress : emailMessage.getTo()) {
                message.addRecipient(Message.RecipientType.TO,
                        new InternetAddress(toAddress));
            }

            message.setSubject(emailMessage.getSubject());
            message.setContent(emailMessage.getText(), emailMessage.getContentType());
            Transport.send(message);

        } catch (Exception e) {
            emailExceptionHandler.onException(e);
        }
    }
}