package commonlibraries.httpclient.apache.examples;


import commonlibraries.httpclient.apache.Response;
import commonlibraries.httpclient.apache.ResponseBuilder;

public interface WithResponseExamples {

    default ResponseBuilder someResponse() {
        return new ResponseBuilder().body("").protocol("HTTP/1.1").statusCode(200);
    }

    default Response responseWithStatusCode(int statusCode) {
        return new ResponseBuilder().body("").protocol("HTTP/1.1").statusCode(statusCode).build();
    }

    default Response responseWithStatusCodeAndBody(int statusCode, String body) {
        return new ResponseBuilder().body(body).protocol("HTTP/1.1").statusCode(statusCode).build();
    }

    default Response responseWithBody(String body) {
        return new ResponseBuilder().protocol("HTTP/1.1").body(body).statusCode(200).build();
    }
}
