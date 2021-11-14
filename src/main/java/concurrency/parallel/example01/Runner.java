package concurrency.parallel.example01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.Timer;

//https://stackoverflow.com/questions/2016083/what-is-the-easiest-way-to-parallelize-a-task-in-java
public class Runner {
  public static void main(String[] args) {
    Logger logger = LoggerFactory.getLogger(Runner.class);
    HealthCheckProbe probe1 = () -> {
      logger.info("probe1");
      processing(5000L);
      return ProbeResult.success("probe1", "desc");
    };
    HealthCheckProbe probe2 = () -> {
      logger.info("probe2");
      processing(2000L);
      return ProbeResult.warn("probe2", "desc");
    };
    HealthCheckProbe probe3 = () -> {
      logger.info("probe3");
      return ProbeResult.failure("probe3", "desc");
    };
    HealthCheckProbe probe4 = () -> {
      logger.info("probe4");
      processing(2000L);
      return ProbeResult.success("probe4", "desc");
    };
    HealthCheckProbe probe5 = () -> {
      logger.info("probe5");
      return ProbeResult.warn("probe5", "desc");
    };
    List<HealthCheckProbe> probes = List.of(probe1, probe2, probe3, probe4, probe5);
    TrackingExecutorServiceFactory executorServiceFactory = new TrackingExecutorServiceFactory(new LoggingUncaughtExceptionHandler(logger));
    ExecutorServiceConcurrently executorServiceConcurrently =
        new ExecutorServiceConcurrently(
            executorServiceFactory, 5); // Can change the size of thread pool

    // All probes will be executed in parallel
    // they will take time
    // then the get method is used to grab all the results, this will grab the result
    // We get the result only after all the tasks are completed.
    List<ProbeResult> result = executorServiceConcurrently.execute(probes);
    // results will be inorder of list
    result.forEach(x -> logger.info(x.name + " " + x.status));
  }

  private static void processing(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
