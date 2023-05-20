package Pages;

import Utlity.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderMenu extends Parent{

    public HeaderMenu()
    {
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(css="[class='header_user_info'] a")
    private WebElement signInButton;

    @FindBy(xpath="(//*[@title='Women'])[1]")
    private WebElement tabMenuWomen;

    @FindBy(xpath="//*[@title='View my shopping cart']")
    private WebElement Cart;






    public WebElement getCart() {
        return Cart;
    }
    public WebElement getTabMenuWomen() {
        return tabMenuWomen;
    }
    public WebElement getSignInButton() {
        return signInButton;
    }
}