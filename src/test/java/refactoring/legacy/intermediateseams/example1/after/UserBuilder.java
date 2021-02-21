package refactoring.legacy.intermediateseams.example1.after;

import refactoring.legacy.intermediateseams.example1.after.trip.Trip;
import refactoring.legacy.intermediateseams.example1.after.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserBuilder {

  List<User> friends = new ArrayList<>();
  List<Trip> trips = new ArrayList<>();

  public static UserBuilder anUser() {
    return new UserBuilder();
  }

  public UserBuilder friendsWith(User friend) {
    friends.add(friend);
    return this;
  }

  public UserBuilder withTrips(Trip... trips) {
    this.trips.addAll(Arrays.asList(trips));
    return this;
  }

  public User build() {
    User user = new User();
    addFriends(user);
    addTrips(user);
    return user;
  }

  private void addTrips(User user) {
    for (Trip trip : trips) {
      user.addTrip(trip);
    }
  }

  private void addFriends(User user) {
    for (User friend : friends) {
      user.addFriend(friend);
    }
  }
}