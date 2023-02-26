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

public class C01_Alerts {
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
    public void test1(){
        //herhangi bir web sitesine gidince veya bir websitesinde herhangi bir işlem yaptığımızda
        //ortaya çıkan uyarılara alert diyoruz

        //eğer bir alert inspect yapabiliyorsa , o alert otomasyon ile kullanılabilir
        //bu tür alert lere HTML alert denir ve bunlar için ekstra bir işlem yapmaya gerek yoktur
        //tüm webelementler gibi locate edp istediğimiz işlemleri yapabiliriz

        //ancak web uygulamalarında HTML alert yanında java script alert de bulunabilir
        //js alert ler locate edilemez
        //selenium da js alert ler için özel bir yöntem geliştirilmiştir

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        //alert te OK tuşuna basın
        driver.switchTo().alert().accept();

        //result kısmında "You successfully clicked an alert"yazdığını test edin

        String expectedResult="You successfully clicked an alert";
        WebElement sonuçyazısı= driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult=sonuçyazısı.getText();

        Assert.assertEquals(expectedResult,actualResult);
    }

}
