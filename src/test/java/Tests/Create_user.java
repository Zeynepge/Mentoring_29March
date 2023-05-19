package Tests;

import Pages.cleverppcPage;
import Utlity.BaseDriver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

//29 March
public class Create_user extends BaseDriver{

    @Test
    public void exampletest1()  {

        driver.get("https://cleverppc.com/prestashop4/");

        Faker faker1=new Faker();

        cleverppcPage cp=new cleverppcPage();

        cp.getSignInButton().click();

        cp.geteMailAdress().sendKeys(faker1.internet().emailAddress());

        cp.getCreateButton().click();

        List<WebElement> genders=cp.getGender();

        int a=(int)(Math.random()*genders.size());

        genders.get(a).click();

        cp.getFirstName().sendKeys(faker1.name().firstName());

        cp.getLastName().sendKeys(faker1.name().lastName());

        cp.getPassWord().sendKeys(faker1.internet().password());

        cp.getSubmitAccount().click();

        Assert.assertTrue(cp.getSuccessMsj().getText().toLowerCase().contains("Your account has been created.".toLowerCase()));

    }
}