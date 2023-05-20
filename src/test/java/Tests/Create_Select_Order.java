package Tests;

import Pages.DialogContent;
import Pages.HeaderMenu;

import Utlity.BaseDriver;
import com.github.javafaker.Faker;
import io.cucumber.java.bs.A;
import io.cucumber.java.eo.Do;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

//29 March
public class Create_Select_Order extends BaseDriver{


    @Test(priority = 1)
     void Registrations()  {

        driver.get("https://cleverppc.com/prestashop4/");

        Faker faker1=new Faker();

        DialogContent dc=new DialogContent();
        HeaderMenu hm=new HeaderMenu();

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

        Assert.assertEquals(total,totalProducts_);

        String total_ship=(dc.getTotalShipping().getText()).substring(1);
        String tax_included=(dc.getTotalPrice().getText()).substring(1);

        double totalShipping=Double.parseDouble(total_ship);
        double total_tax_included=Double.parseDouble(tax_included);

        // TOTAL TAX INCLUDED
        Assert.assertEquals(total_tax_included,(totalProducts_+totalShipping));





















    }


}