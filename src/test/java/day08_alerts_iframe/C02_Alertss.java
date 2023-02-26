package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alertss {
    //"https://the-internet.herokuapp.com/javascript_alerts" adresine gidin


    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void acceptAlert() {
        //bir method oluşturun:acceptAlert
        //    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //    "You successfully clicked an alert" olduğunu test edin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        String expectedistenen = "You successfully clicked an alert";
        WebElement sonuçyazısı = driver.findElement(By.xpath("//p[@id='result']"));

        String actualvarolan = sonuçyazısı.getText();

        Assert.assertEquals(expectedistenen, actualvarolan);

    }

    public void dismissAlert() {
        //bir metod oluşturun:dismissAlert
        //    2.butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //     "successfuly" içermediğini test edin

        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        WebElement sonuçyazısı = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedistenmeyen = "successfuly";
        String actualvarolan = sonuçyazısı.getText();

        Assert.assertFalse(actualvarolan.contains(expectedistenmeyen));
    }

    public void sendKeysAlert() {
        //bir metod oluşturun: sendKeysAlert
        //     3.butona tıklayın, uyarıdaki metin kutusuna isminizi yazın
        //   OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın

        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("akif erdem");
        driver.switchTo().alert().accept();
        WebElement sonuçyazısı= driver.findElement(By.xpath("//p[@id='result']"));
        String expecteddoğrulanankelime="akif erdem";
        String actualvarolan=sonuçyazısı.getText();

        Assert.assertTrue(actualvarolan.contains(expecteddoğrulanankelime));

    }
}