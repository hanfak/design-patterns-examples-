package caching.decorator;

import org.springframework.util.StopWatch;

public class Runner {
  public static void main(String[] args) {
    StopWatch stopWatch;
    CachingDecorator<InstructionOne> loggingUseCaseOne = new CachingDecorator<>(new UseCaseOne());

    stopWatch = new StopWatch();
    stopWatch.start();
    // will get actual value, will be long time
    String blah = loggingUseCaseOne.execute(new InstructionOne("blah"));
    stopWatch.stop();
    System.out.println("blah 1 = " + blah);
    System.out.println("first "  + stopWatch.getTotalTimeNanos());

    stopWatch = new StopWatch();
    stopWatch.start();
    // will get the cached value shorter time
    String blah1 = loggingUseCaseOne.execute(new InstructionOne("blah"));
    stopWatch.stop();
    System.out.println("blah1 = " + blah1);
    System.out.println("second "  + stopWatch.getTotalTimeNanos());

    // Could have some rule to decide this... ie timing etc
    loggingUseCaseOne.invalidateCache();

    stopWatch = new StopWatch();
    stopWatch.start();
    // will get actual value again, will be long time, as cache invalidated
    String blah2 = loggingUseCaseOne.execute(new InstructionOne("blah"));
    stopWatch.stop();
    System.out.println("blah2 = " + blah2);
    System.out.println("second "  + stopWatch.getTotalTimeNanos());

  }
}
