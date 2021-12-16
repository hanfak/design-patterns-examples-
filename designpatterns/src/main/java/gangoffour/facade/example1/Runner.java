package gangoffour.facade.example1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
  private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

  public static void main(String... args) {
    CarEngineFacade carEngineFacade = new CarEngineFacade();
    carEngineFacade.startEngine();
    LOGGER.info("\n\nSpace\n\n");
    carEngineFacade.stopEngine();
  }
}
