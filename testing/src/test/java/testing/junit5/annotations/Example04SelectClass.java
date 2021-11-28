package testing.junit5.annotations;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import testing.junit5.annotations.tags.packageB.ClassBTest;
import testing.junit5.annotations.tests.SomeTest;

@RunWith(JUnitPlatform.class)
@SelectClasses( { Example01.class, ClassBTest.class, SomeTest.class } )
public class Example04SelectClass {
}

// Example01 test wont be selected as it is in the same package as this class