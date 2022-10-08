package stepDefinitions;

import driverImpl.DriverInitialization;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjects.HomePage;
import utils.DataUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class cartValidationSteps {


    private HomePage homePage = new HomePage(DriverInitialization.getDriver());
    private List<WebElement> list;

    @When("User clicked on {string} button")
    public void userClickedOnButton(String text) {

        list = homePage.clickButton();
        for (WebElement element : list) {
            if (element.getText().trim().equalsIgnoreCase(text)) {
                element.click();
                break;
            }
        }

    }

    @And("User clicked on second category {int} under categories section")
    public void userClickedOnSecondCategoryUnderCategoriesSection(int value) {

        int count = 1;
        list = homePage.selectCategory();
        for (WebElement element : list) {
            if (count == value) {
                element.click();
                break;
            } else {
                count++;
            }
        }

    }

    @And("User selected first item {int} in the category")
    public void userSelectedFirstItemInTheCategory(int value) {
        int count = 1;
        list = homePage.selectSpecificProduct();
        for (WebElement element : list) {
            if (count == value) {
                element.click();
                WebElement product = homePage.selectSpecificProductFromCategory(value-1);
                product.click();
                break;
            } else {
                count++;
            }
        }

    }

    @And("User increased the quantity of the product count to {string}")
    public void userIncreasedTheQuantityOfTheProductCountTo(String value) {

        DataUtils.QUANTITY_COUNT = Integer.parseInt(value);
        Select dropdown = new Select(homePage.selectQuantityDropdown());
        dropdown.selectByValue(value);
    }

    @Then("User clicked on Add to cart button")
    public void userClickedOnAddToCartButton() {

        homePage.clickAddToCartButton().click();
        homePage.verifyConfirmationText().getText().trim().equals("Added to Cart");
    }

    @And("User navigated to cart section")
    public void userNavigatedToCartSection() {

        homePage.clickCartButton().click();

    }

    @Then("User verified the name of the product added")
    public void userVerifiedTheNameOfTheProductAdded() {

        String actualText = homePage.verifyProductTitle().getText();
        assertThat(DataUtils.TITLE).as("verify title of the product").contains( actualText.substring(0, actualText.length()-10));

    }

    @And("User verified the price, total and quantity of the product added")
    public void userVerifiedThePriceTotalAndQuantityOfTheProductAdded() {

        SoftAssertions assertions = new SoftAssertions();
        String productPrice = homePage.verifyProductPrice().getText();
        assertions.assertThat(productPrice).as("verify each unit price of the product").isEqualTo(DataUtils.CURRENCY + " " + DataUtils.PRICE + "." + DataUtils.PRICE_DECIMAL);
        String productsCount = homePage.verifyTotalProductsCount().getText();
        assertions.assertThat(productsCount).as("verify count of products added to cart").isEqualTo("Subtotal (" + DataUtils.QUANTITY_COUNT + " items):");
        String totalAmount = homePage.VerifyTotalAmount().getText();
        String total = totalAmount.replace(",", "");
        int totalPrice = DataUtils.PRICE * DataUtils.QUANTITY_COUNT;
        assertions.assertThat(total).as("verify total price of items added to cart").isEqualTo(DataUtils.CURRENCY + " " + totalPrice + "." + DataUtils.PRICE_DECIMAL);
        assertions.assertAll();
    }

}
