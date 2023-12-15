package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.COInformationPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class COInformationSteps {
    private final WebDriver driver = Hooks.driver;
    COInformationPage coinformationpage = new COInformationPage(driver);

    @Then("User has already on 'Checkout Information' page")
    public void verifyOnCOPage () throws InterruptedException {
        Assert.assertTrue(coinformationpage.verifyLabelPage());
        Thread.sleep(1000);
    }

    @When("User input {string} in first name field, {string} in last name field, and {string} in postal code field")
    public void inputInformation (String first, String last, String code) throws InterruptedException {
        coinformationpage.inputFirstName(first);
        coinformationpage.inputLastName(last);
        coinformationpage.inputPostalCode(code);
        Thread.sleep(2000);
    }

    @And("User click continue button")
    public void clickContinueButton () {
        coinformationpage.clickContinueButton();
    }


}
