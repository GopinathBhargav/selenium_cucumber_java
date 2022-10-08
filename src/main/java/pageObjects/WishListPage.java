package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {

    private WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="span.al-intro-banner-header")
    WebElement getTextInWishListPage;


    public WebElement verifyTextInWishListPage()
    {
        return getTextInWishListPage;
    }

}
