package functional.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {
  private boolean isEmailValid(String email) {
    return email.contains("@");
  }

  private boolean isPhoneNumberValid(String phoneNumber) {
    return phoneNumber.startsWith("+0");
  }

  private boolean isAdult(LocalDate dob) {
    return Period.between(dob, LocalDate.now()).getYears() > 16;
  }
  // Issues with this code, as don't know where the issues or where the problem occurs
  public boolean isValid(Customer customer) {
    return isEmailValid(customer.getEmail()) &&
            isPhoneNumberValid(customer.getPhoneNumber()) &&
            isAdult(customer.getDob());
  }
}
