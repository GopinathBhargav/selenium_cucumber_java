package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {

    private WebDriver driver;

    public SigninPage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="input[name='email']")
    WebElement emailTextBox;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(css="span.a-list-item")
    WebElement messageText;

    @FindBy(css="div[class*='a-box-inner'] h1")
    WebElement getSIgnInText;

    public String getURL(){
        return driver.getCurrentUrl();
    }

    public WebElement passEmailText()
    {
        return emailTextBox;
    }

    public WebElement clickContinueButton()
    {
        return continueButton;
    }

    public WebElement verifyMessage()
    {
        return messageText;
    }

    public WebElement verifySignInText()
    {
        return getSIgnInText;
    }

}
