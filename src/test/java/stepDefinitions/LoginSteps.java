package stepDefinitions;

import driverImpl.DriverInitialization;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.SigninPage;
import utils.FileUtils;

import static org.assertj.core.api.Assertions.*;

public class LoginSteps {

    FileUtils file = new FileUtils();
    private HomePage homePage = new HomePage(DriverInitialization.getDriver());
    private SigninPage signinPage = new SigninPage(DriverInitialization.getDriver());


    @Given("User is on Amazon home page")
    public void userIsOnAmazonHomePage() {
        DriverInitialization.getDriver().get(file.readPropertyFile().getProperty("baseURL"));
        assertThat(homePage.getTitle()).as("home page title is")
                .isEqualTo("Welcome to Amazon.ae Shop Online in UAE for Electronics, Apparel, Computers, Grocery & more | Amazon.ae");
    }

    @When("User clicked on signin button")
    public void userClickedOnSigninButton() {
        homePage.clickSignInButton().click();
    }

    @And("User passed valid email {string} not registered on amazon")
    public void userPassedValidEmailNotRegisteredOnAmazon(String email) {
        signinPage.passEmailText().clear();
        signinPage.passEmailText().sendKeys(email);
        signinPage.clickContinueButton().click();
    }

    @Then("User should be able to see the error {string}")
    public void userShouldBeAbleToSeeTheError(String message) {
        String text = signinPage.verifyMessage().getText();
        assertThat(text).as("Error message text while trying to login without registering ").isEqualTo(message);

    }

}
