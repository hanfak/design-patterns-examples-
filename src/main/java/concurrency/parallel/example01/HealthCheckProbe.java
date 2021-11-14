package concurrency.parallel.example01;

import java.util.concurrent.Callable;

public interface HealthCheckProbe extends Callable<ProbeResult> {
    ProbeResult probe();

    @Override
    default ProbeResult call() {
        return probe();
    }
}
