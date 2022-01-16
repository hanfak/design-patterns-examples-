package archunit.example.onionarchitecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchRules;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "archunit.example.onionarchitecture")
public class GroupRulesTest {

  @ArchTest
  public static final ArchRules hexagonal_architecture = ArchRules.in(HexagonalArchitectures.class);

  private static class HexagonalArchitectures {
    @ArchTest
    public static final ArchRule ruleOne = classes()
            .that()
            .resideInAPackage("..service..")
            .should()
            .onlyHaveDependentClassesThat()
            .resideInAnyPackage("..controller..", "..service..", "..adapter..");
    
    @ArchTest
    public static final ArchRule ruleTwo = classes()
            .that()
            .resideInAPackage("..controller..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..controller..", "..service..", "..adapter..");
  }
}