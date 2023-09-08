package org.example.stepdefs;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"@target/failedrerun.txt"},
        glue= {"org.example.stepdefs","Hooks"},
        monochrome = true,
        plugin={"pretty", "rerun:target/failedrerun.txt"}
        )

public class FailedRun extends AbstractTestNGCucumberTests {
    @DataProvider()
    public Object[][] scenario() {
        return super.scenarios();
    }
}
