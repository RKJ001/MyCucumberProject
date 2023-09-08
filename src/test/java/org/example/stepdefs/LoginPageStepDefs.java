package org.example.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.factory.DriverFactory;
import org.example.pages.LoginPage;
import org.testng.Assert;

public class LoginPageStepDefs {

    private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
    private static String title;

    @Given("user is on homepage")
    public void user_is_on_homepage() {
        DriverFactory.getDriver().get("https://magento.softwaretestingboard.com/");
    }
    @When("user clicks on sign in link")
    public void user_clicks_on_sign_in_link() {
        loginPage.clickSignInLink();
    }
    @When("user gets the title of loginpage")
    public void user_gets_the_title_of_loginpage() {
        title=loginPage.getLoginPageTitle();
        System.out.println("Login Page Title is : "+title);
    }
    @Then("loginpage title should be {string}")
    public void loginpage_title_should_be(String expectedTitle) {
        Assert.assertTrue(title.contains(expectedTitle));
    }
    @Then("forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }

    @When("user enters username {string} and enters password {string}")
    public void user_enters_username_and_enters_password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }
    @When("user clicks on Sign In button")
    public void user_clicks_on_sign_in_button() {
        loginPage.clickSignInBtn();
    }
    @Then("user gets the title of homepage")
    public void user_gets_the_title_of_homepage() {
        title=loginPage.getHomePageTitle();
        System.out.println("Home Page Title is :"+title);
    }
    @Then("homepage title should be {string}")
    public void homepage_title_should_be(String expectedTitle) {
        Assert.assertTrue(title.contains(expectedTitle));
    }

}
