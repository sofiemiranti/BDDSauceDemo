package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.example.pageObject.COOverviewPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class COOverviewSteps {
    private final WebDriver driver = Hooks.driver;
    COOverviewPage cooverviewpage = new COOverviewPage(driver);

    @Then("User will be redirected on Checkout Overview Page")
    public void verifyOnCOOverviewPage () throws InterruptedException {
        Assert.assertTrue(cooverviewpage.verifyCOOverviewPage());
        Thread.sleep(1000);
    }

    @And("Verify the price product {string} should be equal to total price")
    public void verifyPrice (String product){
        String actualText = cooverviewpage.getFinalPriceProduct();
        String expectedValue = cooverviewpage.getPriceProduct(product);
        String actualValue = actualText.substring(actualText.indexOf(expectedValue));

        Assert.assertEquals(expectedValue, actualValue);
    }

    @And("Verify the tax value should be equal to 8% from total price")
    public void verifyTax () {
        String Tax = cooverviewpage.getTax();
        String TaxValue = StringUtils.getDigits(Tax);
        double taxValue = Double.parseDouble(TaxValue) / 100.00;
        String taxvalue = Double.toString(taxValue);
        Assert.assertEquals(cooverviewpage.perhitunganTax(),taxvalue);
    }

    @And("Verify total payment should be equal to total product price plus tax")
    public void verifyTotal () {
        String Total = cooverviewpage.getTotal();
        String TotalValue = StringUtils.getDigits(Total);
        double totalValue = Double.parseDouble(TotalValue) / 100 ;
        String totalvalue = Double.toString(totalValue);
        Assert.assertEquals(cooverviewpage.perhitunganTotalCheckout(),totalvalue);
    }

    @When("User click finish button")
    public void clickFinishButton () {
        cooverviewpage.clickFinishButton();
    }

}
