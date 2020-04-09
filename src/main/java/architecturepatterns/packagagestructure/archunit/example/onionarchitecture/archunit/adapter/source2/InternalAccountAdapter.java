package architecturepatterns.packagagestructure.archunit.example.onionarchitecture.archunit.adapter.source2;


import architecturepatterns.packagagestructure.archunit.example.onionarchitecture.archunit.service.Account;
import architecturepatterns.packagagestructure.archunit.example.onionarchitecture.archunit.service.InternalAccountDataSource;

import java.util.Collection;

import static architecturepatterns.packagagestructure.archunit.example.onionarchitecture.archunit.adapter.source1.AccountUtils.accountInEuros;
import static java.util.Collections.singletonList;

public final class InternalAccountAdapter
        implements InternalAccountDataSource {

    @Override
    public Collection<Account> getAccounts() {
        return singletonList(
                accountInEuros("00001000001A",35_000_00)
        );
    }

}
