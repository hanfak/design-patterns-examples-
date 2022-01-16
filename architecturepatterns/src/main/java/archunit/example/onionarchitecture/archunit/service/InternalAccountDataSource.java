package archunit.example.onionarchitecture.archunit.service;

import archunit.example.onionarchitecture.archunit.service.Account;

import java.util.Collection;

public interface InternalAccountDataSource {

    Collection<Account> getAccounts();

}