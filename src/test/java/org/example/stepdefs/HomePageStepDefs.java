package org.example.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.factory.DriverFactory;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class HomePageStepDefs {

    private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
    private HomePage homePage;

    @Given("user already logged into Application")
    public void user_already_logged_into_application(io.cucumber.datatable.DataTable dataTable) {
       List<Map<String,String>> credList=dataTable.asMaps();
       String Email=credList.get(0).get("email");
       String Password=credList.get(0).get("password");
       DriverFactory.getDriver().get("https://magento.softwaretestingboard.com/");
       homePage=loginPage.doLogin(Email,Password);
    }

    @When("user search items in search field")
    public void user_search_items_in_search_field() {
        homePage.searchItem();
    }

    @Then("search result displayed")
    public void search_result_displayed() {
        homePage.searchResult();
    }

    @When("user select size and color")
    public void user_select_size_and_color() {
        homePage.setSelectSize();
        homePage.setSelectColor();
    }

    @When("user clicks on Add to cart button")
    public void user_clicks_on_add_to_cart_button() {
        homePage.clickAddToCartBtn();
    }

    @Then("item should get added to cart")
    public void item_should_get_added_to_cart() {
        homePage.itemAddedCart();
    }
    @Then("checkout button is displayed")
    public void checkout_button_is_displayed(){
        Assert.assertTrue(homePage.showCheckOutBtn());
    }

}
