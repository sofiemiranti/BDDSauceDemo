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
//    @FindBy (xpath = "//*[@id='checkout_summary_container']/div/div[1]/div[3]/div[2]/div[2]/div")
//    private WebElement productPrice;
    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[6]")
    private WebElement finalProductPrice;
    @FindBy (xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[7]")
    private WebElement tax;
    @FindBy (xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[8]")
    private WebElement total;
    @FindBy (xpath = "//button[@id='finish']")
    private WebElement finishButton;

    public boolean verifyCOOverviewPage() {
        return overviewPageLabel.isDisplayed();
    }
//     public String getPriceProduct () {
//        return productPrice.getText();
//     }
    public String getPriceProduct (String product) {
        String locatorProduct1 = "//div[contains(text(),'" +product +"')]/ancestor::div[@class='cart_item']/descendant::div[@class='item_pricebar']/div[@class='inventory_item_price']";
        return webDriver.findElement(By.xpath(locatorProduct1)).getText();
    }

     public String getFinalPriceProduct () {
        return finalProductPrice.getText();
     }

     public String getTax () {
        return tax.getText();
     }

     public String perhitunganTax () {
         String HargaTotal = getFinalPriceProduct();
         String hargatotal = StringUtils.getDigits(HargaTotal);
         double hargaTotal = Double.parseDouble(hargatotal);
         double taxvalueexpected = Math.ceil((8.00 / 100.00) * hargaTotal) / 100 ;
         String TaxValueExpected = Double.toString(taxvalueexpected);
         return TaxValueExpected;
     }

     public String getTotal () {
        return total.getText();
     }

     public String perhitunganTotalCheckout () {
         String HargaTotal = getFinalPriceProduct();
         String hargatotal = StringUtils.getDigits(HargaTotal);
         double hargaTotal = Double.parseDouble(hargatotal) / 100;
         String Pajak = perhitunganTax();
         String pajak = StringUtils.getDigits(Pajak);
         double PAJAK = Double.parseDouble(pajak) / 100;
         double totalcheckout = hargaTotal + PAJAK;
         String totalCheckout = Double.toString(totalcheckout);
         return totalCheckout;
     }

     public void clickFinishButton () {
        finishButton.click();
     }
}
