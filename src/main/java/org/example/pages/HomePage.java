package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    private WebDriver driver;

    private By searchFieldLocator=By.cssSelector("#search");
    private By searchResultLocator= By.cssSelector(".page-title>span");
    private By selectSize=By.xpath("//*[@role='listbox' and @aria-label='Size']/div");
    private By selectColor=By.xpath("//*[@role='listbox' and @aria-label='Color']/div");
    private By addToCartBtn=By.xpath("//button[@type='submit' and @title='Add to Cart']");
    private By hoverItem=By.cssSelector(".product-item-details>strong>a[title='Radiant Tee']");
    private By checkOutBtn=By.cssSelector("button#top-cart-btn-checkout");
    private By myCart=By.cssSelector("a.action.showcart.active");

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void searchItem()
    {
        driver.findElement(searchFieldLocator).sendKeys("yoga", Keys.ENTER);
    }
    public void searchResult()
    {
        driver.findElement(searchResultLocator).getText();
    }
    public void setSelectSize()
    {
        WebElement hover=driver.findElement(hoverItem);
        Actions act=new Actions(driver);
        act.moveToElement(hover);
        driver.findElement(selectSize).click();
    }
    public void setSelectColor()
    {
        WebElement hover=driver.findElement(hoverItem);
        Actions act=new Actions(driver);
        act.moveToElement(hover);
        driver.findElement(selectColor).click();
    }
    public void clickAddToCartBtn()
    {
        WebElement hover=driver.findElement(hoverItem);
        Actions act=new Actions(driver);
        act.moveToElement(hover);

        driver.findElement(addToCartBtn).click();
    }
    public void itemAddedCart()
    {
        driver.findElement(myCart).click();
    }
    public boolean showCheckOutBtn()
    {
        return driver.findElement(checkOutBtn).isDisplayed();
    }
}
