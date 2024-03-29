package integrations.webserver.restful.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;
import java.util.Date;

import static integrations.webserver.restful.TestServer.PATH;


@Path(PATH)
public class TimeResource {

  private final Clock clock;

  public TimeResource(Clock clock) {
    this.clock = clock;
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getCurrentTime() {
    return String.format("It's currently %s!", format(clock.now()));
  }

  private String format(Date now) {
    return new SimpleDateFormat("HH:mm:ss a z").format(now);
  }
}