package step_definitions;

import io.cucumber.java.en.Then;
import org.example.pageObject.COCompletePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class COCompleteSteps {
    private final WebDriver driver = Hooks.driver;
    COCompletePage cocompletePage = new COCompletePage(driver);

    @Then("User will successfully purchasing")
    public void verifyCOComplete () {
        Assert.assertTrue(cocompletePage.verifyCOComplete());
    }
}
