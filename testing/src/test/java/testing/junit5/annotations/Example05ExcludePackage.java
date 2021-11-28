package testing.junit5.annotations;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("testing.junit5.annotations.tags")
@ExcludePackages("testing.junit5.annotations.tags.packageB") // To exclude must specify selectPackages too
public class Example05ExcludePackage {
}
