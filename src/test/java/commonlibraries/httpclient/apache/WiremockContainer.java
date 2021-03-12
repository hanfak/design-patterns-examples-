package commonlibraries.httpclient.apache;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.RequestListener;
import com.github.tomakehurst.wiremock.http.Response;
import com.github.tomakehurst.wiremock.matching.RequestPatternBuilder;
import org.custommonkey.xmlunit.XMLUnit;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static java.lang.String.format;

public class WiremockContainer {

    // this is a hacky way to help our manual tester to get the stub in a good state by running acceptance tests
    public static final boolean MANUAL_TESTING_MODE = false;

    private static final int MANUAL_TESTING_STUB_PORT = 1233;

    private static WireMock wireMock;
    private static WireMockServer wireMockServer;

    private static List<RequestListener> requestListeners = new ArrayList<>();

    static {
        try {
            doNotFetchDTDsOrXSDsWhenParsingXMLFiles();
            if (MANUAL_TESTING_MODE) {
                wireMock = new WireMock(MANUAL_TESTING_STUB_PORT);
            } else {
                wireMockServer = wireMockServer();
                wireMockServer.addMockServiceRequestListener(WiremockContainer::handleWireMockRequestResponse);
                wireMockServer.start();
                startupLog();
                wireMock = new WireMock(wiremockPort());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleWireMockRequestResponse(Request request, Response response) {
        for (RequestListener requestListener : requestListeners) {
            requestListener.requestReceived(request, response);
        }
    }

    private static void startupLog() {
        System.out.println(format("WireMock started up at '%s'", wiremockBaseUrl()));
    }

    private static WireMockServer wireMockServer() {
        return new WireMockServer(wireMockConfig()
                .port(1333));
    }

    public static String wiremockBaseUrl() {
        String wiremockHost = System.getProperty("wiremock.host", "localhost");
        if (wiremockHost.trim().isEmpty()) {
            throw new UnsupportedOperationException("Wiremock host is an empty string, have you set the correct maven profile?");
        }
        return String.format("http://%s:%s", wiremockHost, wiremockPort());
    }

    public static int wiremockPort() {
        if (MANUAL_TESTING_MODE) {
            return MANUAL_TESTING_STUB_PORT;
        } else {
            return wireMockServer.port();
        }
    }

    public static void listen(RequestListener listener) {
        if (!MANUAL_TESTING_MODE) {
            requestListeners.add(listener);
        }
    }

    public static void resetMappings() {
        if (MANUAL_TESTING_MODE) {
            wireMock.resetToDefaultMappings();
        } else {
            requestListeners.clear();
            wireMockServer.resetToDefaultMappings();
        }
    }

    public static void doNotFetchDTDsOrXSDsWhenParsingXMLFiles() {
        EntityResolver entityResolver = (publicId, systemId) -> new InputSource(new StringReader(""));
        XMLUnit.setControlEntityResolver(entityResolver);
        XMLUnit.setTestEntityResolver(entityResolver);
    }

    public static void register(MappingBuilder MappingBuilder) {
        wireMock.register(MappingBuilder);
    }

    public static void verifyThat(int times, RequestPatternBuilder requestPatternBuilder) {
        wireMock.verifyThat(times, requestPatternBuilder);
    }

    public static void verifyThat(RequestPatternBuilder requestPatternBuilder) {
        wireMock.verifyThat(requestPatternBuilder);
    }
}
