package stepDefinitions;

import driverImpl.DriverInitialization;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import pageObjects.HomePage;
import pageObjects.SigninPage;
import pageObjects.WishListPage;

import static org.assertj.core.api.Assertions.*;

public class AccountsAndListSteps {

    private HomePage homePage = new HomePage(DriverInitialization.getDriver());
    private SigninPage signinPage = new SigninPage(DriverInitialization.getDriver());
    private WishListPage wishlistPage = new WishListPage(DriverInitialization.getDriver());
    Actions mouseActions = new Actions(DriverInitialization.getDriver());

    @When("User hovered on Hello, sign in Account & Lists")
    public void userHoveredOnHelloSignInAccountLists() {
        mouseActions.moveToElement(homePage.clickSignInButton()).build().perform();
    }

    @Given("User selected Your orders from the sign in account & lists page")
    public void userSelectedYourOrdersFromTheSignInAccountListsPageWithoutSignin() {
        homePage.clickYourOrdersButton().click();
    }

    @Given("User selected Your Addresses from the sign in account & lists page")
    public void userSelectedYourAddressesFromTheListWithoutSignin() {
        homePage.clickYourAddressButton().click();
    }

    @Then("User should be able to see the {string} page")
    public void userShouldBeAbleToSeeThePage(String message) {
        String actualText = signinPage.verifySignInText().getText().trim();
        assertThat(actualText).as("verification of user navigated to signin page when clicked on your orders link")
                .isEqualTo(message);
    }

    @Given("User selected Your Lists from the sign in account & lists page")
    public void userSelectedYourListsFromTheListWithoutSignin() {
        homePage.clickYourWishListButton().click();
    }

    @Then("User should be able to see the wishlist page containing text {string}")
    public void userShouldBeAbleToSeeTheWishlistPageContainingText(String message) {
        String wishListText = wishlistPage.verifyTextInWishListPage().getText().trim();
        assertThat(wishListText).as("verification of user navigated to wishlist page when clicked on your list link")
                .isEqualTo(message);
    }

    @And("User verify the title of the {string} page as {string}")
    public void userVerifyTheTitleOfThePageAs(String pageLink, String text) {
        assertThat(homePage.getTitle()).as("verify title of " + pageLink + " page").isEqualTo(text);
    }

    @And("User verify the URL of the {string} page as {string}")
    public void userVerifyTheURLOfThePageAs(String text, String url) {
        assertThat(signinPage.getURL()).as("verify title of " + text + " page").isEqualTo(url);

    }

    @And("User verify the URL of the {string} page contains {string}")
    public void userVerifyTheURLOfThePageContains(String text, String url) {
        assertThat(signinPage.getURL()).as("verify title of " + text + " page").contains(url);
    }

}
