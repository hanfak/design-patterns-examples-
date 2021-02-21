package refactoring.legacy.intermediateseams.example1.after;

import org.junit.Before;
import org.junit.Test;
import refactoring.legacy.intermediateseams.example1.after.exception.UserNotLoggedInException;
import refactoring.legacy.intermediateseams.example1.after.trip.Trip;
import refactoring.legacy.intermediateseams.example1.after.user.User;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static refactoring.legacy.intermediateseams.example1.after.UserBuilder.anUser;

public class TripServiceTest {

  @Test(expected = UserNotLoggedInException.class)
  public void shouldThrowExceptionWhenUserIsNotLoggedIn() throws Exception {
    loggedUser = NO_LOGGED_USER;

    tripService.getTripsByUser(UNUSED_USER);
  }

  @Test
  public void shouldNotReturnTripsWhenLoggedUserIsNotAFriend() throws Exception {
    List<Trip> trips = tripService.getTripsByUser(targetUser);

    assertThat(trips.size(), is(equalTo(0)));
  }

  @Test
  public void shouldReturnTripsWhenLoggedUserIsAFriend() throws Exception {
    User john = anUser().friendsWith(loggedUser)
        .withTrips(new Trip(), new Trip())
        .build();

    List<Trip> trips = tripService.getTripsByUser(john);

    assertThat(trips, is(equalTo(john.trips())));
  }

  @Before
  public void initialise() {
    tripService = new TestableTripService();
  }

  private static final User UNUSED_USER = null;
  private static final User NO_LOGGED_USER = null;
  private User loggedUser = new User();
  private User targetUser = new User();
  private TripService tripService;

  // Here is the stubbed out impl of calls to other classes
  // This allows dev to control the calls to other classes, to be able to write the correct test cases
  // instead of calling them directly (which could be slow, or mutate production)
  private class TestableTripService extends TripService {
    @Override
    protected User getLoggedUser() {
      return loggedUser;
    }

    @Override
    protected List<Trip> tripsBy(User user) {
      return user.trips();
    }
  }
}