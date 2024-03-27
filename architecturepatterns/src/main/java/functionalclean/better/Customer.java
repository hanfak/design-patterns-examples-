package functionalclean.better;

import static functionalclean.legacy.Customer.Segment.VIP;

public record Customer(
        String id,
        boolean active,
        boolean behindWithPayments,
        Segment segment
) {

    boolean isNotBehindWithPayments() {
        return !behindWithPayments;
    }

    boolean isVip(){
        return VIP.equals(segment);
    }
enum Segment{
    VIP, REGULAR
}
}
