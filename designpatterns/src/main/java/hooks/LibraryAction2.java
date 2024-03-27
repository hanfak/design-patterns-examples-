package hooks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class LibraryAction2 {

    private static final Logger logger = LoggerFactory.getLogger("APPLICATION");
    private final ExecutorService executorService = Executors.newFixedThreadPool(8);

    private final List<LibraryActionHook> hooks;

    public LibraryAction2(List<LibraryActionHook> hooks) {
        this.hooks = hooks;
    }

    public void execute(Input input) throws InterruptedException, ExecutionException {
        System.out.println("Do work");
        String upperCaseData = input.data().toUpperCase();
        System.out.println("Apply hooks");
        List<Callable<Object>> tasks = new ArrayList<>(hooks.size());


        for (LibraryActionHook hook : hooks) {
            tasks.add(
                    Executors.callable(
                            () -> {
                                try {
                                    hook.execute(new Input(upperCaseData, input.amount()));
                                } catch (Exception ex) {
                                    logger.error("hook throws an exception. Please validate your hook logic", ex);
                                }
                            }));

            List<Future<Object>> responses = executorService.invokeAll(tasks);
            for (Future<Object> response : responses) {
                response.get();
            }
        }
        System.out.println("Finished applying hooks");
        System.out.println("Do work after hooks");
        int amountIncreased = input.amount() + 1;
        System.out.println(new Input(upperCaseData, amountIncreased));
        System.out.println("finished");
    }

}
