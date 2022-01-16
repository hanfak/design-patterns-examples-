package dependencyinjection.crosscutting.better;


public class Runner {

    public static void main(String... args) {
        // Big problem, is temporal coupling, The factory must be set first and immediately use it, in case somewhere else changes the supplier
        SystemDateFactory.init(UtcDate::new);
        Consumer consumer = new Consumer();
        String prodCode = consumer.execute();
        System.out.println("prodCode = " + prodCode);

        SystemDateFactory.init(TestDate::new);
        Consumer consumer1 = new Consumer();
        String testCode = consumer1.execute();
        System.out.println("testCode = " + testCode);
    }
}
