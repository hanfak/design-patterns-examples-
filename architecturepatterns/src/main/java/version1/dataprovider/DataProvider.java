package version1.dataprovider;

import version1.usecase.port.out.LoadDetails;
import version1.usecase.port.out.WriteDetails;

public class DataProvider implements LoadDetails, WriteDetails {

  @Override
  public void writeDetails(WriteDetailsCommand writeDetailsCommand) {
    // Do something with data, use database
    // Transformer dataproviderCommand and add some more state, to a new domain model used exclusively in this layer
    // ie for database stuff
  }

  @Override
  public LoadDetailsResult loadDetails(Id id) {
    // Load data from database
    // validate
    return null;
  }
}
