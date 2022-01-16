package dependencyinjection.crosscutting.standard;

public class Runner {

    public static void main(String... args) {

        SystemDate utcDate = new UtcDate(); // Set at composition root of Prod
        Consumer consumer = new Consumer(utcDate);
        String prodCode = consumer.execute();
        System.out.println("prodCode = " + prodCode);

        SystemDate testDate = new TestDate(); // set in a class under test, or compoistion root of test version
        Consumer consumer1 = new Consumer(testDate);
        String testCode = consumer1.execute();
        System.out.println("testCode = " + testCode);
        //These can be injected into whatever, but it increases the number of dependencies injected, make class more complex/abstract
    }

}
