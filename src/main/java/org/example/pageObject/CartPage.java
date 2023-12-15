package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public static WebDriver webDriver;

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;

    public boolean verifyProduct1List (String product1){
        String locatorProduct1 = "//div[contains(text(),'" + product1 + "')]";
        return webDriver.findElement(By.xpath(locatorProduct1)).isDisplayed();
    }

    public boolean verifyProduct2List (String product2){
        String locatorProduct2 = "//div[contains(text(),'" + product2 + "')]";
        return webDriver.findElement(By.xpath(locatorProduct2)).isDisplayed();
    }

    public void removeProduct (String product){
        String locatorProduct = "//div[contains(text(),'" + product + "')]/ancestor::div[@class='cart_item']//button[text()='Remove']";
        webDriver.findElement(By.xpath(locatorProduct)).click();
    }

    public void clickCheckoutButton () {
        checkoutButton.click();
    }

}
