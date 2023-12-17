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
    public void verifyOnCOOverviewPage () {
        Assert.assertTrue(cooverviewpage.verifyCOOverviewPage());
    }

    @And("Verify the price product {string} in cart list descriptions should be equal to item total")
    public void verifyPrice (String product){
        String expectedValue = cooverviewpage.getPriceProduct(product);
        String actualText = cooverviewpage.getItemTotal();
        String actualValue = actualText.substring(actualText.indexOf(expectedValue));
        Assert.assertEquals(expectedValue, actualValue);
    }

    @And("Verify the tax value displayed should be equal to 8% from total price which is {string}")
    public void verifyTax (String tax) {
        String stringTax = cooverviewpage.getTax();
        String stringTaxValue = StringUtils.getDigits(stringTax);
        double taxValue = Double.parseDouble(stringTaxValue) / 100.00;
        String taxValueActual = Double.toString(taxValue);
        Assert.assertEquals(cooverviewpage.calculationOfTax(),taxValueActual, tax);
    }

    @And("Verify total payment should be equal to item total plus tax")
    public void verifyTotal () {
        String stringTotal = cooverviewpage.getTotal();
        String stringTotalValue = StringUtils.getDigits(stringTotal);
        double totalValue = Double.parseDouble(stringTotalValue) / 100 ;
        String totalValueActual = Double.toString(totalValue);
        Assert.assertEquals(cooverviewpage.calculationOfCheckoutTotal(),totalValueActual);
    }

    @When("User click finish button")
    public void clickFinishButton () {
        cooverviewpage.clickFinishButton();
    }

}
