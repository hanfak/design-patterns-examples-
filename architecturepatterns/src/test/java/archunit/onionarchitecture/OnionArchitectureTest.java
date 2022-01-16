package archunit.onionarchitecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "architecturepatterns.packagagestructure.archunit.onionarchitecture")
public class OnionArchitectureTest {

  @ArchTest
  static final ArchRule onion_architecture_is_respected = onionArchitecture()
          .domainModels("..domain.model..")
          .domainServices("..domain.service..")
          .applicationServices("..application..")
          .applicationServices("..application.cli..")
          .adapter("persistence", "..adapter.persistence..")
          .adapter("rest", "..adapter.rest..");
}