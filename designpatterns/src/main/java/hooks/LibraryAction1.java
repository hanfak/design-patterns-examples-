package hooks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LibraryAction1 {

    private static final Logger logger = LoggerFactory.getLogger("APPLICATION");
    private final List<LibraryActionHook> hooks;

    public LibraryAction1(List<LibraryActionHook> hooks) {
        this.hooks = hooks;
    }

    public void execute(Input input) {
        System.out.println("Do work");
        String upperCaseData = input.data().toUpperCase();
        System.out.println("Apply hooks");
        try {
            hooks.forEach(hook -> hook.execute(new Input(upperCaseData, input.amount())));
        } catch (Exception ex) {
            logger.error("Hook throws an exception. Please validate your hook logic", ex);
        }
        System.out.println("Finished applying hooks");
        System.out.println("Do work after hooks");
        int amountIncreased = input.amount() + 1;
        System.out.println(new Input(upperCaseData, amountIncreased));
        System.out.println("finished");
    }

}
