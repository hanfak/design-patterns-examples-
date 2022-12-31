package refactoring.dry.example1._03_1allshareissues_fix;

public class ClassA implements Service {

    @Override
    public void execute(String input) {
        String result = input.toLowerCase().concat(" people");

        // store in database
        System.out.println(result);
    }

}
