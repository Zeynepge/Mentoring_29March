package Pages;

import Utlity.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Utlity.BaseDriver.driver;

public class cleverppcPage {

    public cleverppcPage()
    {
       PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css="[class='header_user_info'] a")
    private WebElement signInButton;

    @FindBy(id="email_create")
    private WebElement eMailAdress;

    @FindBy(id="SubmitCreate")
    private WebElement createButton;

    @FindBy(xpath="//*[@name='id_gender']")
    private List<WebElement> gender;

    @FindBy(id="customer_firstname")
    private WebElement firstName;

    @FindBy(id="customer_lastname")
    private WebElement lastName;

    @FindBy(id="passwd")
    private WebElement passWord;

    @FindBy(id="submitAccount")
    private WebElement submitAccount;

    @FindBy(css="[class='alert alert-success']")
    private WebElement successMsj;

    public WebElement getSuccessMsj() {
        return successMsj;
    }

    public WebElement getFirstName() {
        return firstName;
    }
    public WebElement getLastName() {
        return lastName;
    }
    public WebElement getPassWord() {
        return passWord;
    }
    public WebElement getSubmitAccount() {
        return submitAccount;
    }
    public List<WebElement> getGender() {
        return gender;
    }
    public WebElement getCreateButton() {
        return createButton;
    }
    public WebElement geteMailAdress() {
        return eMailAdress;
    }
    public WebElement getSignInButton() {
        return signInButton;
    }



}