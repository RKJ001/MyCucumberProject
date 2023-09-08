package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.factory.DriverFactory;
import org.example.util.ConfigReader;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.Properties;

public class AppHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    /*@Before(value="@Smoke",order = 0)
    public void skip_scenario(Scenario scenario)
    {
        System.out.println("Skipped Scenario is :" +scenario.getName());
        Assume.assumeTrue(false);
    }*/

    @Before(order = 0)
    public void getProperty() throws IOException {
        configReader=new ConfigReader();
        prop=configReader.init_prop();
    }
    @Before(order = 1)
    public void launchBrowser(){
        String browserName= prop.getProperty("browser");
        driverFactory=new DriverFactory();
        driver=driverFactory.init_driver(browserName);
    }
    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }
    @After(order = 1)
    public void tearDown(Scenario scenario){
        if(scenario.isFailed())
        {
            String screenshotName=scenario.getName().replaceAll(" ","_");
            byte[] sourcePath=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png",screenshotName);
        }
    }
}
