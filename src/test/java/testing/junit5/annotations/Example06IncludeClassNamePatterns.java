package testing.junit5.annotations;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("testing.junit5.annotations.tags")
@IncludeClassNamePatterns({"^.*ATests?$"})
public class Example06IncludeClassNamePatterns {
}
