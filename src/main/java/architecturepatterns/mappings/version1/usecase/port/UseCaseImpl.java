package architecturepatterns.mappings.version1.usecase.port;

import architecturepatterns.mappings.version1.usecase.port.in.UseCaseInterface;
import architecturepatterns.mappings.version1.usecase.port.out.LoadDetails;
import architecturepatterns.mappings.version1.usecase.port.out.LoadDetails.DataproviderLoadDetailsModel;
import architecturepatterns.mappings.version1.usecase.port.out.LoadDetails.Id;
import architecturepatterns.mappings.version1.usecase.port.out.WriteDetails;
import architecturepatterns.mappings.version1.usecase.port.out.WriteDetails.DataproviderCommand;

public class UseCaseImpl implements UseCaseInterface {

  private final LoadDetails loadDetails;
  private final WriteDetails writeDetails;

  public UseCaseImpl(LoadDetails loadDetails, WriteDetails writeDetails) {
    this.loadDetails = loadDetails;
    this.writeDetails = writeDetails;
  }

  @Override
  public UseCaseResultModel execute(UseCaseCommand command) {
    DataproviderLoadDetailsModel dataproviderLoadDetailsModel = loadDetails.loadDetails(new Id(command.someStateTwo));

    if (dataproviderLoadDetailsModel == null) {
      String someState = command.someStateOne + "blalaalalla";
      DataproviderCommand dataproviderCommand = new DataproviderCommand(someState, command.someStateTwo, true);
      writeDetails.writeDetails(dataproviderCommand);
      return new UseCaseResultModel(String.format("Something done with '%s' and  formatted state to '%s', given id '%s'",
              command.someStateOne, someState, command.someStateTwo));
    }
    return new UseCaseResultModel("Returned this " + dataproviderLoadDetailsModel.someStateOne);
  }
}
