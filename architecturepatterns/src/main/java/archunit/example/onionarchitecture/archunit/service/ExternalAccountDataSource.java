package archunit.example.onionarchitecture.archunit.service;


import archunit.example.onionarchitecture.archunit.service.Account;

import java.util.Collection;

public interface ExternalAccountDataSource {

    Collection<Account> getAccounts();

}