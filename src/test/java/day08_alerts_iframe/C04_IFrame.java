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

public class C04_IFrame {
    //https://the-internet.herokapp.com/iframe adresine gidin
    //bir method oluşturun
    //   "An IFrame containing..." textinin erişilebilir olduğunu test edin
    //    ve konsol da yazdırın
    //TextBox a "merhaba dünya!" yazın
    //TextBox in altında bulunan "Elemental Selenium"
    //Linkinin textinin görünür olduğunu doğrulayın ve konsolda yazdırın.
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
    public void test01() throws InterruptedException {

        //https://the-internet.herokapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokapp.com/iframe");
        //siteye giremediğim için çalışmadı
        //bir method oluşturun
        //   "An IFrame containing..." textinin erişilebilir olduğunu test edin
        //    ve konsol da yazdırın
        WebElement baslıkElement= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslıkElement.isEnabled());
        System.out.println(baslıkElement.getText());

        //TextBox a "merhaba dünya!" yazın
        /*textbox i doğru olarak locate etmemize rağmen driver bulunamadı
        bunun üzerine HTML kodları inceleyince
        textbox in aslında bir IFrame içerisinde olduğunu gördük
        bu durumda önce IFrame i locate edip
        switchTo() ile o IFrame e geçmeliyiz
         */
        WebElement iFrameElementi=driver.findElement(By.id("MCE_0_İFR"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textkutusu= driver.findElement(By.xpath("//body[@id='tinymce']"));
        textkutusu.clear();//text kutusunda var olan yazıyı silmek için
        textkutusu.sendKeys("merhaba akif erdem");


        //TextBox in altında bulunan "Elemental Selenium"
        //Linkinin textinin görünür olduğunu doğrulayın ve konsolda yazdırın.

        /*link yazı elementini doğru locate etmemize reğmen yazdırmadı
        çünkü yukarıda iFrame e geçiş yapmıştık
        önce oradan çıkmamız lazım
         */
        driver.switchTo().defaultContent();
        WebElement linkyazıelementi= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkyazıelementi.isDisplayed());
        System.out.println(linkyazıelementi.getText());

        Thread.sleep(5000);
    }
}
