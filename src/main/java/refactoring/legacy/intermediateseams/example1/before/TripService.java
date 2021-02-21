package refactoring.legacy.intermediateseams.example1.before;

import refactoring.legacy.intermediateseams.example1.before.exception.UserNotLoggedInException;
import refactoring.legacy.intermediateseams.example1.before.trip.Trip;
import refactoring.legacy.intermediateseams.example1.before.trip.TripDAO;
import refactoring.legacy.intermediateseams.example1.before.user.User;
import refactoring.legacy.intermediateseams.example1.before.user.UserSession;

import java.util.ArrayList;
import java.util.List;


public class TripService {

  public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
    List<Trip> tripList = new ArrayList<>();
    User loggedUser = UserSession.getInstance().getLoggedUser();
    boolean isFriend = false;
    if (loggedUser != null) {
      for (User friend : user.getFriends()) {
        if (friend.equals(loggedUser)) {
          isFriend = true;
          break;
        }
      }
      if (isFriend) {
        tripList = TripDAO.findTripsByUser(user);
      }
      return tripList;
    } else {
      throw new UserNotLoggedInException();
    }
  }

}
