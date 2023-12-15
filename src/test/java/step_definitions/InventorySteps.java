package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.InventoryPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class InventorySteps {
    private final WebDriver driver = Hooks.driver;
    InventoryPage inventoryPage = new InventoryPage(driver);

    @And("User has already on inventory page")
    public void verifyOnInventoryPage(){
        Assert.assertTrue(inventoryPage.verifyInventoryPage());
    }

    @When("User sorts products by {string}")
    public void sortProduct(String filter) {
        inventoryPage.sortProduct(filter);
    }

    @When("User click product {string} as product")
    public void clickProduct(String product) throws InterruptedException {
        inventoryPage.clickAddToCartProduct(product);
        Thread.sleep(1000);
    }

    @Then("Verify the number of products in cart is {string}")
    public void verifyNumberOfProduct(String jumlah) throws InterruptedException {
        Assert.assertEquals(inventoryPage.getCountProducts(), jumlah);
        Thread.sleep(1000);
    }


    @And("User click cart button to go to cart page")
    public void clickCartButton() {
        inventoryPage.openCart();
    }

    @Then("User will be redirected to cart page")
    public void verifyCartPage() throws InterruptedException {
        Assert.assertTrue(inventoryPage.verifyCartPage());
        Thread.sleep(1000);
    }


}
