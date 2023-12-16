package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/resources", // Specify the path to your feature files
        glue = {"stepdefinitions"},                 // Specify the package where your step definitions are located
        tags = "@postbooking",
        plugin = {"pretty", "html:target/cucumber-reports.html"} // Specify the plugins you want to use (e.g., "pretty" for console output, "html" for HTML reports)
)
public class TestRunner {
}
