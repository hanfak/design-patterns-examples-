package hooks;

import java.util.List;

public class Main {

    public static void main(String... args) {
        LibraryAction libraryAction = new LibraryAction(List.of(
                x -> System.out.println("Do custom thing"),
                x -> System.out.println("Do next custom thing")));
        libraryAction.execute(new Input("hello", 4));
    }

}

/*
* This pattern allows libraries to allow users to add custom behaviours, at certain points in the execution of a method.
* This pattern allows clients to plug their code in between phases of the specific component’s life cycle
* similar to strategy pattern
*
*
* This helps prevent issues of having to guess what to make configurable, or add behaviour that we dont know the user wants
*
* Issues with allowing code to be injected to chagnge/adapt behaviour:
*   This can lead to code bloat, how many hooks do we add?
*   Can the injected behaviour be safe? Will we need to handle exceptions? The exceptions should be handled and the rest of the hooks continue
*   The performance of the hooks might impact the overall behaviour, might need to handle hooks in parallel, with timeouts,
*        and handle all with in a certian time frame or ignore thsoe that dotn meet that.
*       This add complexity of multi threading
*       The hooks will need to be able to run in parallel, and handle not run in order
*
* */