package functionalclean.better;

public interface CustomerRepository {

    Customer findBy(String customerId);
}
