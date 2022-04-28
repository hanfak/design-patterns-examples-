package concurrency.parallel.example01;


import concurrency.parallel.example01.ExecutorServiceConcurrently;
import concurrency.parallel.example01.HealthCheckProbe;
import concurrency.parallel.example01.ProbeResult;
import concurrency.parallel.example01.TrackingExecutorServiceFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SuppressWarnings("unchecked")
public class ExecutorServiceConcurrentlyTest {

  @Test
  public void invokingAllTasksInExecutorThrowsIllegalStateException() throws InterruptedException {
    InterruptedException cause = new InterruptedException("Blah");
    when(executorService.invokeAll(probes)).thenThrow(cause);

    ExecutorServiceConcurrently executorServiceConcurrently = new ExecutorServiceConcurrently(executorServiceFactory, 2);

    assertThatThrownBy(() -> executorServiceConcurrently.execute(probes))
        .hasMessage("java.lang.InterruptedException: Blah")
        .isInstanceOf(IllegalStateException.class)
        .hasCause(cause);
  }

  @Test
  public void shouldThrowIllegalStateExceptionWithCauseInterruptedExceptionWhenGettingAllFutures() throws InterruptedException, ExecutionException {
    InterruptedException cause = new InterruptedException("Blah");
    when(executorService.invokeAll(probes)).thenReturn(probeFutures);
    when(probeOneFuture.get()).thenReturn(success);
    when(probeTwoFuture.get()).thenThrow(cause);

    ExecutorServiceConcurrently executorServiceConcurrently = new ExecutorServiceConcurrently(executorServiceFactory, 2);

    assertThatThrownBy(() -> executorServiceConcurrently.execute(probes))
        .hasMessage("java.lang.InterruptedException: Blah")
        .isInstanceOf(IllegalStateException.class)
        .hasCause(cause);
  }

  @Test
  public void shouldThrowIllegalStateExceptionWithCauseExecutionExceptionWhenGettingAllFutures() throws InterruptedException, ExecutionException {
    RuntimeException cause = new RuntimeException("Blah");
    ExecutionException cause1 = new ExecutionException(cause);

    when(executorService.invokeAll(probes)).thenReturn(probeFutures);
    when(probeOneFuture.get()).thenReturn(success);
    when(probeTwoFuture.get()).thenThrow(cause1);

    ExecutorServiceConcurrently executorServiceConcurrently = new ExecutorServiceConcurrently(executorServiceFactory, 2);

    assertThatThrownBy(() -> executorServiceConcurrently.execute(probes))
        .hasMessage("java.util.concurrent.ExecutionException: java.lang.RuntimeException: Blah")
        .isInstanceOf(IllegalStateException.class)
        .hasCause(cause1);
  }

  @Before
  public void setUp() {
    when(probeOne.call()).thenReturn(success);
    when(probeTwo.call()).thenReturn(failure);
    when(executorServiceFactory.newFixedThreadPool(2)).thenReturn(executorService);
  }

  private final TrackingExecutorServiceFactory executorServiceFactory = mock(TrackingExecutorServiceFactory.class);
  private final ExecutorService executorService = mock(ExecutorService.class);
  private final HealthCheckProbe probeOne = mock(HealthCheckProbe.class);
  private final HealthCheckProbe probeTwo = mock(HealthCheckProbe.class);
  private final ProbeResult success = ProbeResult.success("name", "description");
  private final ProbeResult failure = ProbeResult.failure("name", "description");
  private final List<HealthCheckProbe> probes = List.of(probeOne, probeTwo);
  private final Future probeOneFuture = mock(Future.class);
  private final Future probeTwoFuture = mock(Future.class);
  private final List probeFutures = Arrays.asList(probeOneFuture, probeTwoFuture);
}
