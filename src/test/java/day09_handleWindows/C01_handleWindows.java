package day09_handleWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {
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
        //amazon ana sayfaya gidin

        driver.get("https://www.amazon.com");
        String ilksayfaHandleDeğeri=driver.getWindowHandle();
        //nutella için arama yaptırın

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        /*
        CDwindow-08BA9BDE6094B175D495A3D9B6F51A38
        bu kod açılan sayfanın unique hash kodudur
        selenium sayfalar arası geçişte bu window handle değerini kullanır

        eğer sayfalar arasında driver imizi gezdiriyorsak ve herhangi bir sayfadan
        şuanda bulunduğumuz sayfaya geçmek istiyorsak
        driver.switchTo().window("CDwindow-08BA9BDE6094B175D495A3D9B6F51A38");
        bu sayfanın window handle değerini girerek bu sayfaya geçişi saglayabiliriz
         */

        //ilk ürünün resmini tıklayarak farklı bir tab olarak açın

        WebElement ilkürünresmi=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));

        driver.switchTo().newWindow(WindowType.TAB);
        System.out.println("driver in title si" +driver.getTitle());
        /*
        bu komutu kullandığımızda driver otomatik olarak oluşturulan new tab a geçer
        yeni tab da görevi gerçekleştirmek için
        adımları baştan alırız
         */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();



        //yeni tab da açılan ürünün title ını yazdırın
        WebElement ürüntitleElement= driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println("ürün titlesi : " + ürüntitleElement.getText());
        System.out.println("ikinci sayfa url değeri : " + driver.getCurrentUrl());
        //ilk sayfaya geçip url i yazdıralım
        driver.switchTo().window(ilksayfaHandleDeğeri);
        System.out.println("ilk sayfa url değeri : " + driver.getCurrentUrl());

    }
}
