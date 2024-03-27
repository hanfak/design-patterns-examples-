package listeners;

public class Main {

    public static void main(String... args) {
        LibraryAction1 libraryAction = new LibraryAction1();
        libraryAction.registerObserver(
                x -> System.out.println("Do custom thing"));
        libraryAction.registerObserver(
                x -> System.out.println("Do next custom thing"));
        libraryAction.execute(new Input("hello", 4));
    }

}
