package integrations.httpclient.decorator;

import java.util.Base64;

import static java.lang.String.format;

public class BasicAuthHeaderFormatter {

    public static String formatBasicAuthHeader(String username, String password) {
        Base64.Encoder encoder = Base64.getEncoder();
        return "Basic " + new String(encoder.encode(format("%s:%s", username, password).getBytes()));
    }

}
