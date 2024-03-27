package functionalclean.better;

public sealed interface MakingReservationFailure permits MakingReservationFailure.InappropriateDuration, MakingReservationFailure.InactiveCustomer {
    record InappropriateDuration() implements MakingReservationFailure{}
    record InactiveCustomer() implements MakingReservationFailure{}

}
