package version1.usecase.port;
// The usecase has no reference to any class outside this package
import version1.usecase.port.in.UseCaseInterface;
import version1.usecase.port.out.LoadDetails;
import version1.usecase.port.out.LoadDetails.LoadDetailsResult;
import version1.usecase.port.out.LoadDetails.Id;
import version1.usecase.port.out.WriteDetails;
import version1.usecase.port.out.WriteDetails.WriteDetailsCommand;

import java.util.Objects;

import static java.lang.String.format;
import static java.util.Objects.isNull;

public class UseCaseImpl implements UseCaseInterface {

  private final LoadDetails loadDetails;
  private final WriteDetails writeDetails;

  public UseCaseImpl(LoadDetails loadDetails, WriteDetails writeDetails) {
    this.loadDetails = loadDetails;
    this.writeDetails = writeDetails;
  }

  @Override
  public UseCaseResultModel execute(UseCaseCommand command) {
    LoadDetailsResult loadDetailsResult = loadDetails.loadDetails(new Id(command.someStateTwo));

    if (isNull(loadDetailsResult)) {
      String someState = command.someStateOne + "blalaalalla";

      WriteDetailsCommand writeDetailsCommand = new WriteDetailsCommand(someState, command.someStateTwo, true);
      writeDetails.writeDetails(writeDetailsCommand);

      return new UseCaseResultModel(format("Something done with '%s' and  formatted state to '%s', given id '%s'",
              command.someStateOne, someState, command.someStateTwo));
    }
    return new UseCaseResultModel("Returned this " + loadDetailsResult.someStateOne);
  }
}
