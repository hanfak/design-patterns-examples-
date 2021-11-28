package testing.junit5.annotations.tags;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("testing.junit5.annotations.tags")
@ExcludeTags("production")
public class NonProductionTests {


}
