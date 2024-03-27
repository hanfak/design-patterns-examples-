package hooks;

import java.util.List;

public class LibraryAction {

    private final List<LibraryActionHook> hooks;

    public LibraryAction(List<LibraryActionHook> hooks) {
        this.hooks = hooks;
    }

    public void execute(Input input) {
        System.out.println("Do work");
        String upperCaseData = input.data().toUpperCase();
        System.out.println("Apply hooks");
        hooks.forEach(hook -> hook.execute(new Input(upperCaseData, input.amount())));
        System.out.println("Finished applying hooks");
        System.out.println("Do work after hooks");
        int amountIncreased = input.amount() + 1;
        System.out.println(new Input(upperCaseData, amountIncreased));
        System.out.println("finished");
    }

}
