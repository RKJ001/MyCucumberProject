package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    private By signinLink=By.cssSelector("li.authorization-link>a");
    private By emailLocator=By.cssSelector("#email");
    private By pwdLocator=By.cssSelector("#pass");
    private By signinbtn=By.cssSelector("button.action.login.primary>span");
    private By forgotPwdLink=By.cssSelector("a.action.remind");

    public LoginPage(WebDriver driver)
    {

        this.driver=driver;
    }
    public void clickSignInLink()
    {
        WebElement loginLink=driver.findElement(signinLink);
        loginLink.click();
    }
    public String getLoginPageTitle()
    {
        return driver.getTitle();
    }
    public String getHomePageTitle()
    {
        return driver.getTitle();
    }
    public boolean isForgotPwdLinkExist()
    {

        return driver.findElement(forgotPwdLink).isDisplayed();
    }
    public void enterEmail(String email)
    {
        WebElement emailInput=driver.findElement(emailLocator);
        emailInput.sendKeys(email);
    }
    public void enterPassword(String password)
    {
        WebElement pwdInput=driver.findElement(pwdLocator);
        pwdInput.sendKeys(password);
    }
    public void clickSignInBtn()
    {
        WebElement loginBtn=driver.findElement(signinbtn);
        loginBtn.click();
    }

    public HomePage doLogin(String em, String pwd)
    {
        driver.findElement(signinLink).click();
        System.out.println("Login With: "+ em + " and " +pwd);
        driver.findElement(emailLocator).sendKeys(em);
        driver.findElement(pwdLocator).sendKeys(pwd);
        driver.findElement(signinbtn).click();
        return new HomePage(driver);
    }

}
