package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {

    private WebDriver driver;

    //private By createAccountLink=By.cssSelector(".header.links>li:nth-of-type(3)>a");
    private By firstName=By.cssSelector("#firstname");
    private By lastName=By.cssSelector("#lastname");
    private By email=By.cssSelector("#email_address");
    private By password=By.cssSelector("#password");
    private By confirmPwd=By.cssSelector("#password-confirmation");
    private By createAccountBtn=By.cssSelector("button[title='Create an Account']>span");
    private By confirmMsg=By.xpath("//*[text()='Thank you for registering with Main Website Store.']");

    public CreateAccountPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public String createAccountPageTitle()
    {
        return driver.getTitle();
    }
    public void createAccountForm(String FirstName,String LastName,String EmailID,String Password,String ConfirmPassword )
    {
        driver.findElement(firstName).sendKeys(FirstName);
        driver.findElement(lastName).sendKeys(LastName);
        driver.findElement(email).sendKeys(EmailID);
        driver.findElement(password).sendKeys(Password);
        driver.findElement(confirmPwd).sendKeys(ConfirmPassword);
    }
    public void clickCreateAccountBtn()
    {
        driver.findElement(createAccountBtn).click();
    }
    public String getConfirmMsg() throws InterruptedException {
        Thread.sleep(10);
        return driver.findElement(confirmMsg).getText();
    }
}
