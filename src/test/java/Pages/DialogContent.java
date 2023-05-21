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

    // Checkout
    @FindBy(xpath = "(//*[@title='Proceed to checkout'])[2]")
    private WebElement proceedToCheckout;

    @FindBy(id="address1")
    private WebElement address1;

    @FindBy(id="city")
    private WebElement city;

    @FindBy(id="id_state")
    private WebElement selectState;

    @FindBy(id="postcode")
    private WebElement zipCode;

    @FindBy(id="phone_mobile")
    private WebElement phoneMobile;

    @FindBy(id="submitAddress")
    private WebElement submitAddress;

    @FindBy(name = "message")
    private WebElement message;

    @FindBy(xpath = "//*[@id='address_delivery']//*")
    private List<WebElement> deliveryAddress;

    @FindBy(xpath = "//ul[@id='address_invoice']//*")
    private List<WebElement> billingAddress;

    @FindBy(name="processAddress")
    private WebElement proceedToCheckout2;

    @FindBy(id="id_address_delivery")
    private WebElement selectDeliveryAddress;

    @FindBy(css = "[class='carrier_title']")
    private WebElement addressName;

    @FindBy(id = "cgv")
    private WebElement iAgree;

    @FindBy(name = "processCarrier")
    private WebElement proceedToCheckout3;

    @FindBy(id = "total_price")
    private WebElement totalPricePayment;

    @FindBy(css="[class='bankwire']")
    private WebElement bankWire;

    @FindBy(css="[class='cheque']")
    private WebElement payCheck;

    @FindBy(css = "[class='button btn btn-default button-medium']")
    private WebElement confirm;

    @FindBy(id = "amount")
    private WebElement amount;

    @FindBy(css = "[class='alert alert-success']")
    private WebElement success;




    public WebElement getSuccess() {
        return success;
    }
    public WebElement getAmount() {
        return amount;
    }
    public WebElement getConfirm() {
        return confirm;
    }
    public WebElement getBankWire() {
        return bankWire;
    }
    public WebElement getPayCheck() {
        return payCheck;
    }
    public WebElement getTotalPricePayment() {
        return totalPricePayment;
    }
    public WebElement getProceedToCheckout3() {
        return proceedToCheckout3;
    }
    public WebElement getiAgree() {
        return iAgree;
    }
    public WebElement getAddressName() {
        return addressName;
    }
    public WebElement getSelectDeliveryAddress() {
        return selectDeliveryAddress;
    }
    public WebElement getProceedToCheckout2() {
        return proceedToCheckout2;
    }
    public List<WebElement> getDeliveryAddress() {
        return deliveryAddress;
    }
    public List<WebElement> getBillingAddress() {
        return billingAddress;
    }
    public WebElement getMessage() {
        return message;
    }
    public WebElement getSubmitAddress() {
        return submitAddress;
    }
    public WebElement getPhoneMobile() {
        return phoneMobile;
    }
    public WebElement getZipCode() {
        return zipCode;
    }
    public WebElement getSelectState() {
        return selectState;
    }
    public WebElement getCity() {
        return city;
    }
    public WebElement getAddress1() {
        return address1;
    }
    public WebElement getProceedToCheckout() {
        return proceedToCheckout;
    }
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