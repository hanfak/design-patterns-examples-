package listeners;

import hooks.LibraryActionHook;

import java.util.ArrayList;
import java.util.List;

public class LibraryAction1 {

    private final List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(Input input) {
        for (Observer observer : observers) {
            observer.update(input);
        }
    }

    public void execute(Input input) {
        System.out.println("Do work");
        String upperCaseData = input.data().toUpperCase();
        System.out.println("Apply listeners");
        notifyObservers(new Input(upperCaseData, input.amount()));
        System.out.println("Finished applying listeners");
        // Here if we need the results of the listeners, we need to stop the execution, and perform the rest of the excution
        // after receving a notification from the listener
        System.out.println("Do work regardless of whether listeners are finised");
        int amountIncreased = input.amount() + 1;
        System.out.println(new Input(upperCaseData, amountIncreased));
        System.out.println("finished");
    }

}
