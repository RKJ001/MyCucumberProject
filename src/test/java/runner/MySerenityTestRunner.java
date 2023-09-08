package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"runner"},
        features = {"src/test/resources/features/loginpage.feature"}
)
public class MySerenityTestRunner {

}
