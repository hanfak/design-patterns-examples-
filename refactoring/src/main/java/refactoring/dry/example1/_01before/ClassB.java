package refactoring.dry.example1._01before;

public class ClassB {

    public void execute(String input) {
        String result = input.toLowerCase();

        // send request to http server
        System.out.println(result);
    }

}
