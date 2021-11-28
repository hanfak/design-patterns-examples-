package architecturepatterns.packagagestructure.archunit.example.onionarchitecture.archunit.adapter.source1;


import architecturepatterns.packagagestructure.archunit.example.onionarchitecture.archunit.service.Account;
import architecturepatterns.packagagestructure.archunit.example.onionarchitecture.archunit.service.ExternalAccountDataSource;

import java.util.Collection;

import static architecturepatterns.packagagestructure.archunit.example.onionarchitecture.archunit.adapter.source1.AccountUtils.accountInEuros;
import static java.util.Arrays.asList;

public final class ExternalAccountAdapter
        implements ExternalAccountDataSource {

    @Override
    public Collection<Account> getAccounts() {
        return asList(
                accountInEuros("000000000123456X",12_99),
                accountInEuros("000000000987654T", -23_00)
        );
    }

}