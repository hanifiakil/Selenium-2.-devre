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

public class C02_BestBuyAssertions {
    //https://www.bestbuy.com/ adresine gidn
    //farklı test method ları oluşturarak aşağıdaki testleri yapın
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test1() {
        //  sayfa url inin https://www.bestbuy.com/ a eşit olduğunu test edin

        String expectedURL="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,actualUrl);
    }
    @Test
    public void test2() {
        //  titletest=>sayfa başlığının "Rest" içermediğini(contains) test edin

        String istenmeyenkelime="Rest";
        String actualTitle= driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenkelime));

    }
    @Test
    public void test3() {
        //  logotest => BestBuy logosunun görüntülendiğini test edin
        WebElement logoelement=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoelement.isDisplayed());
    }
    @Test
    public void test4() {
        //  FrancaisLinkTest => Fransızca linkin görüntülendiğini test edin

        WebElement fransızcalink= driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(fransızcalink.isDisplayed());
    }
}
