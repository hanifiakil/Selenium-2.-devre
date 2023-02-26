package day09_handleWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test01(){
        //1-amazon anasayfaya gidelim

        driver.get("https://www.amazon.com");

        String ilksayfahandledeğeri=driver.getWindowHandle();
        //2-url in amazon içerdiğini test edelim

        String istenenkelime="amazon";

        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(istenenkelime));

        //3-yeni bir pencere açıp bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.bestbuy.com");
        String ikincisayfahandledeğeri=driver.getWindowHandle();

        //4-title in Best Buy içerdiğini test edelim

        String aranankelime="Best Buy";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(aranankelime));

        //5-ilk sayfaya dönüp sayfada java aratalım

        driver.switchTo().window(ilksayfahandledeğeri);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java" + Keys.ENTER);

        //6-arama sonuçlarının java içerdiğini test edelim

        WebElement sonuçyazısıelementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonuçyazısıStr=sonuçyazısıelementi.getText();
        String aranankelimejava="java";
        Assert.assertTrue(sonuçyazısıStr.contains(aranankelimejava));

        //7-yeniden BestBuy ın açık olduğu sayfaya gidelim

        driver.switchTo().window(ikincisayfahandledeğeri);

        //8-logonun görüldüğünü test edelim
        WebElement logoelementi= driver.findElement(By.xpath("//img[@class='logo']"));
        Assert.assertTrue(logoelementi.isDisplayed());
    }
}
