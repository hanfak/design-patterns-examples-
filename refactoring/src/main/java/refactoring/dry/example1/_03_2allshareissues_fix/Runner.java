package refactoring.dry.example1._03_2allshareissues_fix;

import java.util.function.Function;
import java.util.stream.Stream;

public class Runner {

    public static void main(String... args) {

        new ClassA(new AddedWorkToSharedWorkerImpl(new SharedWorkerImpl ())).execute("Hello");
        new ClassB(new SharedWorkerImpl()).execute("Hello");

        System.out.println("XXXXXXXXXXXXXXXXXXXX");
        Function<SharedWorker, Service> classAFactory = sharedWorker -> new ClassA(new AddedWorkToSharedWorkerImpl(sharedWorker));
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


        System.out.println("XXXXXXXXXXXXXXXXXXXX");
        Function<SharedWorker, Service> classAFactory1 = sharedWorker -> new ClassA(sharedWorker);
        Function<SharedWorker, Service> classBFactory1 = sharedWorker -> new ClassB(sharedWorker);
        Function<SharedWorker, Service> classCFactory1 = sharedWorker -> new ClassC(sharedWorker);
        Function<SharedWorker, Service> classDFactory1 = sharedWorker -> new ClassD(sharedWorker);

        Stream.of(classAFactory1, classBFactory1, classCFactory1, classDFactory1)
                .map(factory -> {
                    final double random = Math.random(); // This can be some user input
                    if (random > 0.5) {
                        return factory.apply(new SharedWorkerImpl());
                    }
                    return factory.apply(new AddedWorkToSharedWorkerImpl(new SharedWorkerImpl ()));
                })
                .forEach(service -> service.execute("Hello"));

    }
}
