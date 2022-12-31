package refactoring.dry.example1._01before;

public class ClassA {

    public void execute(String input) {
        String result = input.toLowerCase();

        // store in database
        System.out.println(result);
    }

}
