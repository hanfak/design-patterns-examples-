package architecturepatterns.packagagestructure.archunit.example.onionarchitecture.archunit.service;

import java.util.Collection;

public interface InternalAccountDataSource {

    Collection<Account> getAccounts();

}