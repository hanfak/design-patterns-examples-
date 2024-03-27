package functionalclean.legacy;

public interface CustomerRepository {

    Customer findBy(String customerId);
}
