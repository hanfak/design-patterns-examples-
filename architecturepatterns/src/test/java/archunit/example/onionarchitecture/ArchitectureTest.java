package archunit.example.onionarchitecture;

import archunit.example.onionarchitecture.common.LogDescription;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchRules;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.*;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAPackage;
import static com.tngtech.archunit.core.domain.JavaModifier.PUBLIC;
import static com.tngtech.archunit.core.domain.properties.HasModifiers.Predicates.modifier;
import static com.tngtech.archunit.core.domain.properties.HasOwner.Functions.Get;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.all;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "architecturepatterns.packagagestructure.archunit.example.onionarchitecture")
public class ArchitectureTest {

  @ArchTest // Should fail
  public static final ArchRule all_entry_points_should_be_annotated_with_log_description = all(new AbstractClassesTransformer<JavaMethod>("methods") {
    @Override
    public Iterable<JavaMethod> doTransform(final JavaClasses javaClasses) {
      return javaClasses.stream()
              .flatMap(javaClass -> javaClass.getMethods().stream())
              .collect(toList());
    }
  })
          .that(Get.<JavaClass>owner().is(resideInAPackage("architecturepatterns.packagagestructure.archunit.example.onionarchitecture.archunit.controller..")))
          .and(modifier(PUBLIC).as("are public"))
          .should(new ArchCondition<JavaMethod>("annotated with " + LogDescription.class) {
            @Override
            public void check(final JavaMethod method, final ConditionEvents events) {
              boolean typeMatches = method.isAnnotatedWith(LogDescription.class);
              final String message = format("%s annotated with %s",
                      method.getFullName(), method.getAnnotations().stream()
                              .map(annotation -> annotation.getType().getSimpleName())
                              .collect(toList()));
              events.add(new SimpleConditionEvent(method, typeMatches, message));
            }
          });

  @ArchTest
  public static final ArchRule adapters_do_not_depend_on_one_another = slices()
          .matching("architecturepatterns.packagagestructure.archunit.example.onionarchitecture.(adapter).(*)..")
          .namingSlices("$1 '$2'")
//          .ignoreDependencies("architecturepatterns.packagagestructure.archunit.example.onionarchitecture.archunit.adapter.*..", "architecturepatterns.packagagestructure.archunit.example.onionarchitecture.archunit.adapter.common..")
          .should().notDependOnEachOther();


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
            .onlyHaveDependentClassesThat()
            .resideInAnyPackage("..controller..", "..service..", "..adapter..");
  }
}