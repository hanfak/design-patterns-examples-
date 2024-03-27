package functionalclean.legacy;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record Lending(
        UUID id,
        String CustomerId,
        String vehicleId,
        String stationId,
        Instant reservationTime,
        Integer reservationDurationInMinutes,
        Instant lendingStartTime,
        Instant returnTime,
        String returnStationId,
        BigDecimal distanceInKm,
        int extensionCount
) {

}
