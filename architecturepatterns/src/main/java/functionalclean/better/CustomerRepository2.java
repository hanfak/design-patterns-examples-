package functionalclean.better;

import io.vavr.control.Either;
import org.checkerframework.checker.units.qual.C;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface CustomerRepository2 {

    Either<DatabaseFailure, Customer> findBy(String customerId);
}
