package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C03_Assertions {

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
    driver.close();
}
@Test
    public void test1(){// site askıya alındığndan dolayı devam edemedk
    //https://automationpractice.com/index.php sayfasına gidelim
    driver.get("https://automationpractice.com/index.php");
    driver.findElement(By.xpath("//button[@id='details-button']")).click();
    driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
    //sign in butonuna basalım
    driver.findElement(By.xpath("MMMMMM")).click();
    //email kutusuna @işareti olmayan bir mail yazıp enter a bastığımızda
    WebElement mailkutusu= driver.findElement(By.xpath("nnnnn"));
    mailkutusu.sendKeys("hanifi2769gmail.com"+ Keys.ENTER);
    //   "Invalid email address" uyarısı çıktığını test edelim

    WebElement uyarıyazısı=driver.findElement(By.xpath("YYYY"));
    Assert.assertTrue(uyarıyazısı.isDisplayed());


}


}
