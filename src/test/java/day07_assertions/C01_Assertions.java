package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*amazon ana sayfaya gidin
    3 farklı test method u oluşturarak aşağıdaki görevleri yapın
    1- Url in amazon içerdiğini test edin
    2-title nin facebook içermediğini test edn
    3-sol üst köşede amazon logosunun görüldüğünü test edin
     */
static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test1(){

        //1- Url in amazon içerdiğini test edin
        String aranankelime="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(aranankelime));

    }
    @Test
    public void test2(){
        //2-title nin facebook içermediğini test edn
        String istenmeyenkelime="facebook";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenkelime));
    }

    @Test
    public void test3(){
        //3-sol üst köşede amazon logosunun görüldüğünü test edin
        WebElement logoelementi=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoelementi.isDisplayed());}

}
