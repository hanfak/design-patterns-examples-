package functionalclean.legacy;

import java.time.Instant;
import java.util.UUID;

public class LendingService {
    private final LendingRepository lendingRepository;
    private final CustomerRepository customerRepository ;

    public LendingService(LendingRepository lendingRepository, CustomerRepository customerRepository) {
        this.lendingRepository = lendingRepository;
        this.customerRepository = customerRepository;
    }

    void makeReservation(String vehicleId, String stationId, String customerId, Integer reservationDurationInMinutes) {
       Customer customer =  customerRepository.findBy(customerId);
       if (customer.active() && customer.isNotBehindWithPayments()) {
           if( (customer.isVip() && reservationDurationInMinutes <= 20) || reservationDurationInMinutes <= 5) {
               Lending reservation = new Lending(UUID.randomUUID(), customerId, vehicleId, stationId, Instant.now(), reservationDurationInMinutes, null, null, null, null, 0);
               lendingRepository.save(reservation);
           } else {
               throw new IllegalArgumentException("Inappropiate duration");
           }
        } else {
           throw new IllegalArgumentException("Customer is not active or is behind with payments");
       }
    }

    private boolean isReservationActive(Lending lending) {
        return lending.reservationDurationInMinutes() != null && lending.lendingStartTime() == null;
    }

    private boolean isLendingInProgress(Lending lending) {
        return lending.lendingStartTime() != null && lending.returnTime() == null;
    }
}
