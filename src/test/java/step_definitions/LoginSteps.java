package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private final WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);

    @Given("User has already on login page")
    public void verifyUserNameField(){
        Assert.assertTrue(loginPage.verifyUsernameField());
        Assert.assertTrue(loginPage.verifyPasswordField());
    }


    @When("User input {string} as username and {string} as password")
    public void credential(String userName, String password){
        loginPage.inputUsernameField(userName);
        loginPage.inputPasswordField(password);
        loginPage.clickLoginButton();
    }

    @Then("User will be redirected to inventory page")
    public void verifyToInventoryPage(){
        Assert.assertTrue(loginPage.verifyInventoryPage());
    }

    @Then("User will see error message {string} on login page")
    public void verifyLabelErrorText(String errorText) {
        Assert.assertEquals(loginPage.getErrorTextLabel(),errorText);
    }
}
