package org.example.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.example.factory.DriverFactory;
import org.example.pages.CreateAccountPage;
import org.example.util.ExcelReader;
import org.testng.Assert;
import org.yaml.snakeyaml.constructor.SafeConstructor;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CreateAccountStepDefs {

    private CreateAccountPage createAccountPage=new CreateAccountPage(DriverFactory.getDriver());

    @Given("user navigates to create account page")
    public void user_navigates_to_create_account_page() {
        DriverFactory.getDriver().get("https://magento.softwaretestingboard.com/customer/account/create/");
    }

    @When("user fills form from given sheetname {string} and rownumber {int}")
    public void user_fills_form_from_given_sheetname_and_rownumber(String SheetName, Integer RowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader=new ExcelReader();
        List<Map<String,String>> testData=reader.getData("G:\\selenium\\Projects\\ExampleCucumber\\automation.xlsx",SheetName);
        String firstName=testData.get(RowNumber).get("FirstName");
        String lastName=testData.get(RowNumber).get("LastName");
        String emailid=testData.get(RowNumber).get("EmailID");
        String password=testData.get(RowNumber).get("Password");
        String confirmpassword=testData.get(RowNumber).get("ConfirmPassword");

        createAccountPage.createAccountForm(firstName,lastName,emailid,password,confirmpassword);
    }

    @When("user clicks on create an account button")
    public void user_clicks_on_create_an_account_button() throws InterruptedException {
        createAccountPage.clickCreateAccountBtn();
        Thread.sleep(10);
    }

    @Then("it shows successfull message {string}")
    public void it_shows_successfull_message(String expectedMessage) throws InterruptedException {
        Thread.sleep(10);
        String actualMessage=createAccountPage.getConfirmMsg();
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
