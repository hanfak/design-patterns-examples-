package archunit.example.onionarchitecture.archunit.service;

import archunit.example.onionarchitecture.archunit.adapter.source2.InternalAccountAdapter;
import archunit.example.onionarchitecture.common.LogDescription;
import lombok.extern.log4j.Log4j2;

import java.util.Collection;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;


@Log4j2
public class AggregationService {

    private final InternalAccountAdapter internalDataSource;
    private final ExternalAccountDataSource externalDataSource;

    public AggregationService(final InternalAccountAdapter internalDataSource,
                              final archunit.example.onionarchitecture.archunit.service.ExternalAccountDataSource externalDataSource) {
        this.internalDataSource = internalDataSource;
        this.externalDataSource = externalDataSource;
    }

    @LogDescription("Get all accounts")
    public Collection<archunit.example.onionarchitecture.archunit.service.Account> getAccounts() {
        log.info("Get list of accounts");
        return concat(
                this.internalDataSource.getAccounts().stream(),
                this.externalDataSource.getAccounts().stream()
        ).collect(toList());
    }

}