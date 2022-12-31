package refactoring.dry.example1._03allshareissues;

import java.util.function.Function;
import java.util.stream.Stream;

public class Runner {

    public static void main(String... args) {
        // A is happy, but D is now using the wrong implementation but it was shared
        new ClassA(new SharedWorkerImpl()).execute("Hello");
        new ClassB(new SharedWorkerImpl()).execute("Hello");

        System.out.println("XXXXXXXXXXXXXXXXXXXX");
        // This will cause issues now as the dependency will use the wrong implementation and have no control over it
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
