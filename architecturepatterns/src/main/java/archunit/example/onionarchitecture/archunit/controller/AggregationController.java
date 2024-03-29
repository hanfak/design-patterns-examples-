package archunit.example.onionarchitecture.archunit.controller;

import archunit.example.onionarchitecture.archunit.service.Account;
import archunit.example.onionarchitecture.archunit.service.AggregationService;

import java.util.Collection;

public class AggregationController {

    private final AggregationService service;

    public AggregationController(final AggregationService service) {
        this.service = service;
    }

    public Collection<Account> getAccounts(){
        return this.service.getAccounts();
    }

}