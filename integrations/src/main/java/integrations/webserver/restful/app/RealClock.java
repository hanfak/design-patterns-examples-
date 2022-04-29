package integrations.webserver.restful.app;


import integrations.webserver.restful.resources.Clock;

import java.util.Date;

public class RealClock implements Clock {

  @Override
  public Date now() {
    return new Date();
  }
}
