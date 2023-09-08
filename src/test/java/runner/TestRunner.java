package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features/",
        glue= {"org.example.stepdefs","Hooks"},
        plugin={"pretty","html:target/cucumber-reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/",
                "rerun:target/failedrerun.txt"},
        //tags = "not @Smoke",  //skip testcase by writing not
        //tags = "@AddingItem",
        monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {

    @DataProvider()
    public Object[][] scenario()

    {
        return super.scenarios();
    }
}
