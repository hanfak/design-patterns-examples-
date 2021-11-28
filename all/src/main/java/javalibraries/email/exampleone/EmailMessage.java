package javalibraries.email.exampleone;

import java.util.HashSet;
import java.util.Set;

public class EmailMessage {
    private Set<String> to = new HashSet<String>();
    private String from;
    private String subject;
    private String text;
    private String contentType;

    public EmailMessage(Set<String> to, String from, String subject, String text, String contentType) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.text = text;
        this.contentType = contentType;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public String getContentType() {
        return contentType;
    }

    public Set<String> getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String toString() {
        return "EmailMessage{" +
                "to=" + to +
                ", from='" + from + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}