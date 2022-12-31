package refactoring.dry.example1._01before;

public class ClassC {

    public void execute(String input) {
        String result = input.toLowerCase();

        // send message to queue
        System.out.println(result);
    }

}
