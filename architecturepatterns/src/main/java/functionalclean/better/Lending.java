package functionalclean.better;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record Lending(
        UUID id,
        functionalclean.better.CustomerId CustomerId,
        VehicleId vehicleId,
        StationId stationId,
        Instant reservationTime,
        ReservationDuration reservationDurationInMinutes,
        Instant lendingStartTime,
        Instant returnTime,
        String returnStationId,
        BigDecimal distanceInKm,
        int extensionCount
) {

}
