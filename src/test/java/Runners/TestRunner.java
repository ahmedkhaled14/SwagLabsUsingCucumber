package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="G:\\SwagLabsUsingCucumber\\src\\test\\java\\features"
        ,glue = "steps",tags = "@e2eTest", plugin = {"pretty" , "html:target/report.html"})
public class TestRunner {
}
