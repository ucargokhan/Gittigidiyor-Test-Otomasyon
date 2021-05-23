// Generated by Selenium IDE
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Gittigidiyor {
    private static final Logger logger = LogManager.getLogger(Gittigidiyor.class);
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Gokhan\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {

        //driver.quit();
    }

    @Test
    public void gittigidiyor() {

        String openingUrl = "https://www.gittigidiyor.com/";
        String expectedTitle = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";

        //opening gittigidiyor home page
        driver.get(openingUrl);

        //checking if the home page is opened according to whether the home page title is valid or not.
        if(driver.getTitle() != null && driver.getTitle().contains(expectedTitle)){
            logger.info("Home page successfully opened");
        }
        else{
            logger.info("Error occured with home page");
            Assert.fail();;
        }

        //opening login page
        driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div[1]/div[3]/div/div[1]/div/div[1]/div")).click();
        driver.get("https://www.gittigidiyor.com/uye-girisi?s=1");


        //logging in
        driver.findElement(By.id("L-UserNameField")).sendKeys("gokhanucar171622@gmail.com");
        driver.findElement(By.id("L-PasswordField")).sendKeys("fenerli17");
        driver.findElement(By.id("gg-login-enter")).click();

        driver.get(openingUrl);

        //checking if the login was successful according to title.
        if(driver.getTitle() != null && driver.getTitle().contains(expectedTitle)){
            logger.info("Login successful");
        }
        else{
            logger.info("Error occured with login");
            Assert.fail();
        }

        //waiting for 1 seconds
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        //typing and searching for 'bilgisayar'
        driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input")).submit();
        logger.info("Başarılı");
        {
            WebElement element = driver.findElement(By.id("search-keyword"));
            logger.info("Başarılı 2");
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.id("search-keyword")).sendKeys("bilgisayar");
        logger.info("Başarılı 3");
        driver.findElement(By.name("submit_detay")).click();
        logger.info("Başarılı 4");

        //need to close ad.
        // xpath: /html/body/div[6]/div/img[1]
        driver.findElement(By.xpath("/html/body/div[6]/div/img[1]")).click();

        //closing policy alert to let the automation click on second page
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/a")).click();
        logger.info("Başarılı 5");

        //navigating second page
        List<WebElement> li = driver.findElements(By.linkText("2"));
        li.get(0).click();//If there are only two such element, here 1 is index of 2nd element in list returned.
        logger.info("Başarılı 6");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //opening a random product from second page
        driver.findElement(By.cssSelector("#item-info-block-690443836 .product-title > span")).click();
        logger.info("Başarılı 7");

        //product price is defining
        String price1 = driver.findElement(By.id("sp-price-lowPrice")).getText();
        logger.info("Başarılı 8");

        //product added to basket
        driver.findElement(By.id("add-to-basket")).click();
        logger.info("Başarılı 9");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        //navigating to basket
        driver.findElement(By.className("basket-icon-container")).click();
        logger.info("Başarılı 10");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //basket price is defining
        String price2 = driver.findElement(By.className("new-price")).getText();
        logger.info("Başarılı 11");

        //comparing product and basket prices
        if(price1.equals (price2))
        {
            logger.info("Product and basket price are same.");
        }
        else
        {
            logger.info("Product and basket price are not the same. There may be a discount.");
        }

        //making the product amount '2'
        driver.findElement(By.cssSelector(".gg-input-select > .amount")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector(".gg-input-select > .amount"));
            dropdown.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div/div[6]/div[2]/div[2]/div[1]/div[4]/div/div[2]/select/option[2]")).click();
        }
        driver.findElement(By.cssSelector(".gg-input-select > .amount")).click();

        //quantity of the product is assigned to a variable
        String quantity = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[3]/div/div[1]/div/div[5]/div[1]/div/ul/li[1]/div[1]")).getText();

        //checking if the quantity is equal to '2'
        if(quantity.equals("Ürün Toplamı (2 Adet)")){
            logger.info("Quantity is good to go.");
        }
        else{
            logger.info("We have a problem.");
            Assert.fail();
        }

        //emptying basket
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/a[1]/i")).click();
        if(driver.getPageSource().contains("bulunmamaktadır"))
        {
            logger.info("Test başarılı.");
        }

        else
        {
            logger.info("We have a problem.");
            Assert.fail();
        }



    }
}
