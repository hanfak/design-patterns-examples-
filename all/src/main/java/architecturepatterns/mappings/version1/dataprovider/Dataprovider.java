package architecturepatterns.mappings.version1.dataprovider;

import architecturepatterns.mappings.version1.usecase.port.out.LoadDetails;
import architecturepatterns.mappings.version1.usecase.port.out.WriteDetails;

public class Dataprovider implements LoadDetails, WriteDetails {

  @Override
  public void writeDetails(DataproviderCommand dataproviderCommand) {
    // Do something with data, use database
    // Transformer dataproviderCommand and add some more state, to a new domain model used exclusively in this layer
    // ie for database stuff
  }

  @Override
  public DataproviderLoadDetailsModel loadDetails(Id id) {
    // Load data from database
    // validate
    return null;
  }
}
