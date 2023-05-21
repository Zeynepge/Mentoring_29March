package Tests;

import Pages.DialogContent;
import Pages.HeaderMenu;

import Utlity.BaseDriver;
import com.github.javafaker.Faker;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import java.util.List;

//29 March
public class Create_Select_Order extends BaseDriver{
    Faker faker1=new Faker();
    public static double tt;


    @Test(priority = 1)
     void Registrations()  {

        driver.get("https://cleverppc.com/prestashop4/");

        HeaderMenu hm=new HeaderMenu();
        DialogContent dc=new DialogContent();

        hm.getSignInButton().click();

        dc.geteMailAdress().sendKeys(faker1.internet().emailAddress());

        dc.getCreateButton().click();

        List<WebElement> genders=dc.getGender();

        int a=(int)(Math.random()*genders.size());

        genders.get(a).click();

        dc.getFirstName().sendKeys(faker1.name().firstName());

        dc.getLastName().sendKeys(faker1.name().lastName());

        dc.getPassWord().sendKeys(faker1.internet().password());

        dc.getSubmitAccount().click();

        Assert.assertTrue(dc.getSuccessMsj().getText().toLowerCase().contains("Your account has been created.".toLowerCase()));

    }

    @Test(dependsOnMethods = "Registrations")
    void Select_Randomly() throws InterruptedException {

        Actions actions=new Actions(driver);

        DialogContent dc=new DialogContent();
        HeaderMenu hm=new HeaderMenu();

        actions.moveToElement(hm.getTabMenuWomen()).click().build().perform();

        // We randomly select 3 products
        int[] number= new int[3];
        int a=0;
        for (int i = 0; i < 3; i++) {
            int b=(int)(Math.random()* dc.getListProduct().size());
            for (int j = 0; j < i; j++) {
                if (number[j]==b) {
                    a = 1;
                    break;}
            }
            if (a==0)
                number[i]=b;
            else {a=0;  i--; }
        }

        for (int i = 0; i < 3; i++) {
            actions.moveToElement(dc.getListProduct().get(number[i])).click().build().perform();

            wait.until(ExpectedConditions.elementToBeClickable(dc.getAddToCart().get(number[i])));

            actions.moveToElement(dc.getAddToCart().get(number[i])).click().build().perform();

            wait.until(ExpectedConditions.elementToBeClickable(dc.getContinueShopping()));

            actions.moveToElement(dc.getContinueShopping()).click().build().perform();
        }

        hm.getCart().click();
        // We are in cart  // Wir sind im Warenkorb

        int mal=0;
        for (int i = 0; i < number.length; i++) {

             for (WebElement e:dc.getListProduktInCart())
                 {
                 if(e.getText().contains(dc.getProductNames().get(number[i]+1).getText()))
                    { mal++;break;}
                 }
        }
        Assert.assertEquals(mal,3);

        double total=0;

        for (WebElement e:dc.getUnitPriceList()) {
            String price=e.getText();
            String b2=price.substring(1);
            total+=Double.parseDouble(b2);
        }

        String totalProducts =(dc.getTotalProduct().getText()).substring(1);

        double totalProducts_=Double.parseDouble(totalProducts);

        DecimalFormat df=new DecimalFormat("#.##");
        total=Double.valueOf(df.format(total));

        Assert.assertEquals(total,totalProducts_);

        String total_ship=(dc.getTotalShipping().getText()).substring(1);
        String tax_included=(dc.getTotalPrice().getText()).substring(1);

        double totalShipping=Double.parseDouble(total_ship);
        double total_tax_included=Double.parseDouble(tax_included);

        tt=totalProducts_+totalShipping;

        tt=Double.valueOf(df.format(tt));

        // TOTAL TAX INCLUDED
        Assert.assertEquals(total_tax_included,tt);

        dc.getProceedToCheckout().click();

    }

    @Test(dependsOnMethods = "Select_Randomly")
    void ProceedToCheckout() throws InterruptedException, AWTException {

        DialogContent dc=new DialogContent();
        HeaderMenu hm=new HeaderMenu();

        dc.getAddress1().sendKeys(faker1.address().fullAddress());
        dc.getCity().sendKeys(faker1.address().city());

        Select stateMenu=new Select(dc.getSelectState());
        int a=(int) (Math.random()*(stateMenu.getOptions().size()-1)+1);
        stateMenu.selectByIndex(a);

        dc.getZipCode().sendKeys("12345");
        dc.getPhoneMobile().sendKeys(faker1.phoneNumber().cellPhone());

        dc.getSubmitAddress().click();

        // popup close
        Robot rbt =new Robot();
        for (int i = 0; i < 63; i++) {
            rbt.keyPress(KeyEvent.VK_TAB);
            rbt.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(10);
        }
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);

        int aa=0;
        for (int i = 2; i < 7; i++) {

            if(dc.getDeliveryAddress().get(i).getText().equalsIgnoreCase(dc.getBillingAddress().get(i).getText()))
             aa++;
            if (aa==5)
                break;
        }
        Assert.assertEquals(aa,5);

        // Select delivery address
        Select addressMenu=new Select(dc.getSelectDeliveryAddress());
        //int c=(int)(Math.random()*(addressMenu.getOptions().size()-1)+1);
        addressMenu.selectByIndex(0);

        String adres=addressMenu.getOptions().get(0).getText();

        dc.getProceedToCheckout2().click();

        Assert.assertTrue(dc.getAddressName().getText().contains(adres));

        dc.getiAgree().click();
        dc.getProceedToCheckout3().click();

        //CHOOSE PAYMENT METHOD

        String ttPrice=dc.getTotalPricePayment().getText().substring(1);
        Assert.assertEquals(tt,Double.parseDouble(ttPrice));

        int c=(int)(Math.random()*1);

        if(c==0)
            dc.getBankWire().click();
        else
            dc.getPayCheck().click();

        String amount=dc.getAmount().getText().substring(1);
        Assert.assertEquals(tt,Double.parseDouble(amount));

        dc.getConfirm().click();
        Assert.assertTrue(dc.getSuccess().getText().contains("Your order on Xu Clothing is complete"));

    }


}