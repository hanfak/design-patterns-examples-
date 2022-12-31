package refactoring.dry.example1._02allshare;

import java.util.function.Function;
import java.util.stream.Stream;

public class Runner {

    public static void main(String... args) {
        // Can instantiate separately what we want
        new ClassA(new SharedWorkerImpl()).execute("Hello");
        new ClassB(new OtherSharedWorkerImpl()).execute("Hello");

        System.out.println("XXXXXXXXXXXXXXXXXXXX");
        // Could do this with reflection, but using factory here
        Function<SharedWorker, Service> classAFactory = sharedWorker -> new ClassA(sharedWorker);
        Function<SharedWorker, Service> classBFactory = sharedWorker -> new ClassB(sharedWorker);
        Function<SharedWorker, Service> classCFactory = sharedWorker -> new ClassC(sharedWorker);
        Function<SharedWorker, Service> classDFactory = sharedWorker -> new ClassD(sharedWorker);

        Stream.of(classAFactory, classBFactory, classCFactory, classDFactory)
                .map(factory -> {
                    final double random = Math.random(); // This can be some user input
                    if (random > 0.5) {
                       return factory.apply(new SharedWorkerImpl());
                    }
                    return factory.apply(new OtherSharedWorkerImpl());
                })
                .forEach(service -> service.execute("Hello"));
    }
}
