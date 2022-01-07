package email.exampleone;

public interface EmailSender {
    void sendMessage(String host,
                     Integer port,
                     EmailMessage emailMessage,
                     EmailExceptionHandler emailExceptionHandler);
}