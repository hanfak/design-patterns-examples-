package refactoring.legacy.intermediateseams.example1.after;

import refactoring.legacy.intermediateseams.example1.after.exception.UserNotLoggedInException;
import refactoring.legacy.intermediateseams.example1.after.trip.Trip;
import refactoring.legacy.intermediateseams.example1.after.trip.TripDAO;
import refactoring.legacy.intermediateseams.example1.after.user.User;
import refactoring.legacy.intermediateseams.example1.after.user.UserSession;

import java.util.ArrayList;
import java.util.List;


public class TripService {

  public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
    List<Trip> tripList = new ArrayList<>();
    User loggedUser = getLoggedUser();
    boolean isFriend = false;
    if (loggedUser != null) {
      for (User friend : user.getFriends()) {
        if (friend.equals(loggedUser)) {
          isFriend = true;
          break;
        }
      }
      if (isFriend) {
        tripList = tripsBy(user);
      }
      return tripList;
    } else {
      throw new UserNotLoggedInException();
    }
  }
  // Created seams (calls to other classes, dependencies) by extracting calls to dep into methods
  // protected so that they can be overridden in test, with a stubbed impl to control for tests
  // Will be extracted out as dependencies (either constructor or parameter), as these methods are not private and breaks
  // encapsulation and can be used elsewhere
  // This allows us to not change prod code before having a full set of tests
  protected List<Trip> tripsBy(User user) {
    return TripDAO.findTripsByUser(user);
  }

  // If the constructor cannot be changed, can use overloading, and by these methods to into it
  // If method signature cannot be changed, can stick with the protected method seams
  //    or overload the public method, but this may not be possible if method is defined in interface class
  protected User getLoggedUser() {
    return UserSession.getInstance().getLoggedUser();
  }
}
