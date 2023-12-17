package org.example.pageObject;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class COOverviewPage {
    public static WebDriver webDriver;

    public COOverviewPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy (xpath = "//span[@class='title']")
    private WebElement overviewPageLabel;
    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[6]")
    private WebElement priceProductTotal;
    @FindBy (xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[7]")
    private WebElement tax;
    @FindBy (xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[8]")
    private WebElement total;
    @FindBy (xpath = "//button[@id='finish']")
    private WebElement finishButton;

    public boolean verifyCOOverviewPage() {
        return overviewPageLabel.isDisplayed();
    }

    public String getPriceProduct (String product) {
        String locatorProduct1 = "//div[contains(text(),'" +product +"')]/ancestor::div[@class='cart_item']/descendant::div[@class='item_pricebar']/div[@class='inventory_item_price']";
        return webDriver.findElement(By.xpath(locatorProduct1)).getText();
    }

     public String getItemTotal () {
        return priceProductTotal.getText();
     }

     public String getTax () {
        return tax.getText();
     }

     public String calculationOfTax () {
         String getItemTotal = getItemTotal();
         String stringPriceProduct = StringUtils.getDigits(getItemTotal);
         double itemTotal = Double.parseDouble(stringPriceProduct);
         double taxValueExpected = Math.ceil((8.00 / 100.00) * itemTotal) / 100 ;
         String stringTaxValueExpected = Double.toString(taxValueExpected);
         return stringTaxValueExpected;
     }

     public String getTotal () {
        return total.getText();
     }

     public String calculationOfCheckoutTotal () {
         String getItemTotal = getItemTotal();
         String stringItemTotal = StringUtils.getDigits(getItemTotal);
         double itemTotal = Double.parseDouble(stringItemTotal) / 100;
         String stringTax = calculationOfTax();
         double tax = Double.parseDouble(stringTax);
         double totalCheckout = itemTotal + tax;
         String stringTotalCheckoutExpected = Double.toString(totalCheckout);
         return stringTotalCheckoutExpected;
     }

     public void clickFinishButton () {
        finishButton.click();
     }
}
