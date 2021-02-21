package refactoring.legacy.intermediateseams.example1.before.trip;

import refactoring.legacy.intermediateseams.example1.before.exception.DependendClassCallDuringUnitTestException;
import refactoring.legacy.intermediateseams.example1.before.user.User;

import java.util.List;

public class TripDAO {

  public static List<Trip> findTripsByUser(User user) {
    throw new DependendClassCallDuringUnitTestException(
        "TripDAO should not be invoked on an unit test.");
  }

}
