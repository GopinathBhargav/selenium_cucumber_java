package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DataUtils;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="a[data-nav-role='signin']")
    WebElement getSigninButton;

    @FindBy(xpath = "//div[@id='nav-xshop']/a")
    List<WebElement> clickButtonBasedOnText;

    @FindBy(xpath = "//span[@aria-label='Departments filter'] //input[@type='checkbox']")
    List<WebElement> selectCategoryCheckBox;

    @FindBy(css = "div[data-testid='grid-deals-container'] a[class*='a-link-normal']")
    List<WebElement> selectProduct;

    @FindBy(xpath = "//div[@id='octopus-dlp-asin-stream'] //li")
    List<WebElement> selectFirstProduct;

    @FindBy(id = "quantity")
    WebElement selectQuanity;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement clickAddToCart;

    @FindBy(css = "div[class*='sw-atc-message-section'] span")
    WebElement getConfirmationText;

    @FindBy(xpath = "//a[@id='nav-cart']")
    WebElement getCartButton;

    @FindBy(css = "span.a-truncate-cut")
    WebElement getTitleOfTheProduct;

    @FindBy(css = "span[class*='sc-product-price']")
    WebElement getPriceAndCurrency;

    @FindBy(css= "span#sc-subtotal-label-activecart")
    WebElement getSubTotalItemsCount;

    @FindBy(css="span#sc-subtotal-amount-activecart span")
    WebElement getSubTotalAmount;

    @FindBy(xpath = "//a[@id='nav_prefetch_yourorders']")
    WebElement getYourOrdersLink;

    @FindBy(xpath = "//a[@id='nav_prefetch_youraddresses']")
    WebElement getYourAddressLink;

    @FindBy(xpath = "//span[contains(text(),'Your Lists')]")
    WebElement getYourWishListLink;

    @FindBy(xpath = "//a[contains(@class,'a-size-base')]")
    WebElement getTitle;

    public WebElement clickSignInButton()
    {
        return getSigninButton;
    }

    public List<WebElement> clickButton()
    {
        return clickButtonBasedOnText;
    }

    public List<WebElement> selectCategory()
    {
        return selectCategoryCheckBox;
    }

    public List<WebElement> selectSpecificProduct()
    {
        return selectProduct;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public WebElement selectQuantityDropdown()
    {
        return selectQuanity;
    }

    public WebElement clickAddToCartButton()
    {
        return clickAddToCart;
    }

    public WebElement verifyConfirmationText()
    {
        return getConfirmationText;
    }

    public WebElement clickCartButton()
    {
        return getCartButton;
    }

    public WebElement verifyProductTitle()
    {
        return getTitleOfTheProduct;
    }

    public WebElement verifyProductPrice()
    {
        return getPriceAndCurrency;
    }

    public WebElement verifyTotalProductsCount()
    {
        return getSubTotalItemsCount;
    }

    public WebElement VerifyTotalAmount()
    {
        return getSubTotalAmount;
    }

    public WebElement clickYourOrdersButton()
    {
        return getYourOrdersLink;
    }

    public WebElement clickYourAddressButton()
    {
        return getYourOrdersLink;
    }

    public WebElement clickYourWishListButton()
    {
        return getYourWishListLink;
    }

    public WebElement selectSpecificProductFromCategory(int index)
    {
        WebElement productDetails = selectFirstProduct.get(index);
        DataUtils.TITLE = productDetails.findElement(By.xpath("//a[contains(@class,'a-size-base')]")).getText();
        DataUtils.CURRENCY = productDetails.findElement(By.xpath("//span[@class='a-price-symbol']")).getText();
        DataUtils.PRICE = Integer.parseInt(productDetails.findElement(By.xpath("//span[@class='a-price-whole']")).getText());
        DataUtils.PRICE_DECIMAL = productDetails.findElement(By.xpath("//span[@class='a-price-fraction']")).getText();
        return productDetails;
    }
}
