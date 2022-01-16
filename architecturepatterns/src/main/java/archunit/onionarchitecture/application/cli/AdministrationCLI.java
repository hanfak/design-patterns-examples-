package archunit.onionarchitecture.application.cli;

import archunit.onionarchitecture.application.ShoppingApplication;
import archunit.onionarchitecture.application.AdministrationPort;
import archunit.onionarchitecture.domain.service.ProductRepository;

@SuppressWarnings("unused")
public class AdministrationCLI {
    public static void main(String[] args) {
        AdministrationPort port = ShoppingApplication.openAdministrationPort();
        handle(args, port);
    }

    private static void handle(String[] args, AdministrationPort port) {
        // violates the pairwise independence of adapters
        ProductRepository repository = port.getInstanceOf(ProductRepository.class);
        long count = repository.getTotalCount();
        // parse arguments and re-configure application according to count through port
    }
}
