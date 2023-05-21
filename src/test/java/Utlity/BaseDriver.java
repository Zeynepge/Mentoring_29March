package Utlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void beforeClass(){

        ClosePrevious();

        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");


        ChromeOptions options = new ChromeOptions();
             options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window(). maximize();

        Duration dr=Duration.ofSeconds(10);
        driver.manage().timeouts().pageLoadTimeout(dr);

        driver.manage().timeouts().implicitlyWait(dr);

        wait=new WebDriverWait(driver, Duration.ofSeconds(50));


          //   options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
            // options.addArguments("start-maximized");
           //  options.addArguments("test-type");
            // options.addArguments("disable-notifications");
           //  options.AddUserProfilePreference("autofill.profile_enabled", false);
    }
    @AfterClass
    public void afterClass(){
        try {
            Thread.sleep(3000);
           // driver.quit();
        }catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void ClosePrevious(){
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored){

        }

    }

}
