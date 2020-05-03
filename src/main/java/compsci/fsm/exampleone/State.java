package compsci.fsm.exampleone;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public enum State {
  Ready(true, "Deposit", "Quit"),
  Waiting(true, "Select", "Refund"),
  Dispensing(true, "Remove"),
  Refunding(false, "Refunding"),
  Exiting(false, "Quiting");

  State(boolean exp, String... in) {
    inputs = Arrays.asList(in);
    explicit = exp;
  }

  State nextState(String input, State current) {
    if (inputs.contains(input)) {
      return map.getOrDefault(input, current);
    }
    return current;
  }

  final List<String> inputs;
  final static Map<String, State> map = new HashMap<>();
  final boolean explicit;

  static {
    map.put("Deposit", State.Waiting);
    map.put("Quit", State.Exiting);
    map.put("Select", State.Dispensing);
    map.put("Refund", State.Refunding);
    map.put("Remove", State.Ready);
    map.put("Refunding", State.Ready);
  }
}
