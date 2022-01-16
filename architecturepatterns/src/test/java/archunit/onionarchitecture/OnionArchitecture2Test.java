package archunit.onionarchitecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "architecturepatterns.packagagestructure.archunit.onionarchitecture")
public class OnionArchitecture2Test {

  @ArchTest
  public static final ArchRule rule = Architectures.layeredArchitecture()
          .layer("Services").definedBy("..domain.service..")
          .layer("Models").definedBy("..domain.model..")
          .layer("Domain").definedBy("..domain..")
          .layer("Adapter").definedBy("..adapter..")
          .layer("Application").definedBy("..application..")

          .whereLayer("Application").mayNotBeAccessedByAnyLayer()
          .whereLayer("Adapter").mayOnlyBeAccessedByLayers("Application")
          .whereLayer("Domain").mayOnlyBeAccessedByLayers("Adapter", "Application")
          .whereLayer("Services").mayOnlyBeAccessedByLayers("Adapter", "Application")
          .whereLayer("Models").mayOnlyBeAccessedByLayers("Services", "Adapter", "Application")
          .as("");

  @ArchTest
  public static final ArchRule adapters_do_not_depend_on_one_another = slices()
          .matching("architecturepatterns.packagagestructure.archunit.onionarchitecture.(adapter).(*)..").namingSlices("$1 '$2'")
          .should().notDependOnEachOther()
          .as("Adapters do not depend on one another")
          .because("Adapters should only depend on one external system; depending on other adapters is likely to imply pulling dependencies towards other external systems");
}
