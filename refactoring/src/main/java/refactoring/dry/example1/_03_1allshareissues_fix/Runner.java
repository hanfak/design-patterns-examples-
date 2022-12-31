package refactoring.dry.example1._03_1allshareissues_fix;

import java.util.function.Function;
import java.util.stream.Stream;

public class Runner {

    public static void main(String... args) {

        new ClassA().execute("Hello");
        new ClassB(new SharedWorkerImpl()).execute("Hello");

        System.out.println("XXXXXXXXXXXXXXXXXXXX");
        // Not as nice, but can be certain that ABCD uses correct impl
        Function<SharedWorker, Service> classAFactory = sharedWorker -> new ClassA();
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
