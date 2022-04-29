package apache;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.api.Assertions;

import java.util.regex.Pattern;

import static apache.Header.CONTENT_TYPE_KEY;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class AbstractThenTheResponse<Then extends AbstractObjectAssert<Then, ActualResponse>, ActualResponse extends Response> extends AbstractObjectAssert<Then, ActualResponse> {

    protected final ActualResponse response;

    public AbstractThenTheResponse(ActualResponse response, Class<Then> thenClass) {
        super(response, thenClass);
        this.response = response;
    }

    public Then hasStatusCode(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);
        return myself;
    }

    public Then hasContentType(String contentType) {
        assertThat(response.headerValue(CONTENT_TYPE_KEY)).startsWith(contentType);
        return myself;
    }

    public Then hasBody(String body) {
        assertThat(response.body()).isEqualTo(body);
        return myself;
    }

    public Then hasNoBody() {
        assertThat(response.body()).isNullOrEmpty();
        return myself;
    }

    public Then bodyHasJsonPathWithValue(String jsonPath, String expectedValue) {
        if (!containsJsonPathValue(response.body(), jsonPath, expectedValue)) {
            Assertions.fail(format("%nJsonPath '%s' could not find '%s' in body:%n%s%n", jsonPath, expectedValue, response.body()));
        }
        return myself;
    }

    public Then bodyContains(String string) {
        if (!response.body().contains(string)) {
            Assertions.fail(format("%nCould not find '%s' in body:%n%s%n", string, response.body()));
        }
        return myself;
    }

    public Then bodyMatchesRegex(String regex) {
        if (!Pattern.compile(regex, Pattern.DOTALL).matcher(response.body()).matches()) {
            Assertions.fail(format("%nCould not match regex '%s' in body:%n%s%n", regex, response.body()));
        }
        return myself;
    }

    public Then isXml() {
        hasHeaderStartingWith("Content-Type", "application/xml");
        return myself;
    }

    public Then isJson() {
        hasHeaderStartingWith("Content-Type", "application/json");
        return myself;
    }

    public Then isPlainText() {
        hasHeaderStartingWith("Content-Type", "text/plain");
        return myself;
    }

    private boolean containsJsonPathValue(String body, String jsonPath, String expectedValue) {
        return expectedValue.equals(evaluateJsonPath(body, jsonPath));
    }


    private String evaluateJsonPath(String body, String jsonPath) {
        DocumentContext documentContext = JsonPath.parse(body);
        return documentContext.read(jsonPath);
    }

    public Then hasHeader(String headerKey, String headerValue) {
        assertThat(response.headerValue(headerKey)).isEqualTo(headerValue);
        return myself;
    }

    public Then hasHeaderStartingWith(String headerKey, String headerValue) {
        assertThat(response.headerValue(headerKey)).startsWith(headerValue);
        return myself;
    }

    public Then hasHeaderThatMatches(String headerKey, String regex) {
        assertThat(response.headerValue(headerKey)).matches(regex);
        return myself;
    }

    public Then isSuccessful() {
        assertThat(response.isSuccessful()).describedAs("is successful").isTrue();
        return myself;
    }

    public Then isNotSuccessful() {
        assertThat(response.isSuccessful()).describedAs("is not successful").isFalse();
        return myself;
    }

    public Then isRejectedAsBadRequestWithErrorCode(String errorCode) {
        isNotSuccessful();
        assertThat(response.statusCode()).isEqualTo(400);
        bodyHasJsonPathWithValue("$.errorCode", errorCode);
        return myself;
    }

    public Then andDescription(String errorDescription) {
        bodyHasJsonPathWithValue("$.errorDescription", errorDescription);
        return myself;
    }
}
