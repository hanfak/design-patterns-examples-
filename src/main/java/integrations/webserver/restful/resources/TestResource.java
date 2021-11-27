package integrations.webserver.restful.resources;



import integrations.webserver.restful.app.TestUseCase;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class TestResource {

  private final TestUseCase useCase;

  public TestResource(TestUseCase useCase) {
    this.useCase = useCase;
  }

  @GET
  @Path("test")
  @Produces(MediaType.TEXT_PLAIN)
  public String usecase() {
    return "Test" + useCase.execute();
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String test() {
    return "Test";
  }
}