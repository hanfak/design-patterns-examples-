package testing.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber", "junit:target/report/cucumber_junit_report.xml"},
        tags = "not @Ignore",
        monochrome = true,
        features = {"classpath:features"})
public class CucumberTest {
}
