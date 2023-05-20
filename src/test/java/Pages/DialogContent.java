package Pages;

import Utlity.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DialogContent extends Parent {

    public DialogContent()
    {
       PageFactory.initElements(BaseDriver.driver, this);
    }

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

    @FindBy(xpath="//*[@id='product_list']/li")
    private List<WebElement> listProduct;

    @FindBy(css="[class='product-name']")
    private List<WebElement> productNames;

    @FindBy(xpath = "//*[@title='Add to cart']")
    private List<WebElement> addToCart;

    @FindBy(xpath = "//*[@title='Continue shopping']")
    private WebElement continueShopping;

    @FindBy(xpath ="//*[@class='cart_description']/p")
    private List<WebElement> listProduktInCart;

    // Unit price
    @FindBy(xpath = "//*[@class='price text-right']/li[1]")
    private List<WebElement> unitPriceList;

    @FindBy(id="total_product")
    private WebElement totalProduct;

    @FindBy(id="total_shipping")
    private WebElement totalShipping;

    @FindBy(id="total_price_without_tax")
    private WebElement totalPrice;



    public WebElement getTotalPrice() {
        return totalPrice;
    }
    public WebElement getTotalShipping() {
        return totalShipping;
    }
    public WebElement getTotalProduct() {
        return totalProduct;
    }
    public List<WebElement> getUnitPriceList() {
        return unitPriceList;
    }
    public List<WebElement> getListProduktInCart() {
        return listProduktInCart;
    }
    public List<WebElement> getProductNames() {
        return productNames;
    }
    public WebElement getContinueShopping() {
        return continueShopping;
    }
    public List<WebElement> getAddToCart() {
        return addToCart;
    }
    public List<WebElement> getListProduct() {
        return listProduct;
    }
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




}