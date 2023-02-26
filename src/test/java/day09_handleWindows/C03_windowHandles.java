package day09_handleWindows;

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
import java.util.Set;

public class C03_windowHandles {
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
        //https://the-internet.herokuapp.com/window adresine gidin

        driver.get("https://the-internet.herokuapp.com/window");

        //sayfadaki textin "Opening a new window" olduğunu doğrulayın.

        WebElement sayfadakiyazıelementi= driver.findElement(By.xpath("//h3"));
        String expectedYazı="Opening a new window";
        String actualYazı= sayfadakiyazıelementi.getText();
        Assert.assertEquals(expectedYazı,actualYazı);

        //sayfa başlığının (title) "The Internet" olduğunu doğrulatın.

        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        /*
        eğer kontrolsüz açılan bir tab veya window varsa
        ozaman sayfaların window handle değerlerini elde etmem gerekir
        öncelikle 2. sayfa açılmadan önce ilk sayfanın window handle değerini bir String e atayalım
         */

        String ilksayfaWindowHandleDeğeri= driver.getWindowHandle();


        //Click Here butonuna basın

        driver.findElement(By.linkText("Click Here"));
        /*switcTo().newWindow demeden link tıklayarak yeni tab veya
        window oluşturduğunda biz driver a yeni sayfaya geç demedikçe driver
        eski sayfada kalır ve yeni sayfa ile ilgili hiçbir işlem yapamaz
        yeni sayfada driver i çalıştırmak isterseniz önce driver i yeni sayfaya yollamalısınız
         */

        /*
        yeni sayfaya geçebilmek için öncelikle ikincisayfawindowhandledeğerini
        almamız gerekir. bunun için driver.getWindowHandles() method unu kullanarak
        açık olan tüm sayfaların window handle değerlerini alıp bir set eassign ederiz

        ilk sayfanın window handle değerini zaten biliyoruz
        set deki window handle değerlerini konntrol edip
        ilk sayfanın handle değerine eşit olmayan
        ikinci sayfanın window handle değeridir deriz.

         */

        Set<String> windowHandleseti= driver.getWindowHandles();
        System.out.println(windowHandleseti);
        String ikincisayfaWindowHandleDeğeri="";
        for (String each: windowHandleseti
             ) {
            if (!each.equals(ilksayfaWindowHandleDeğeri)){
                ikincisayfaWindowHandleDeğeri=each;
            }
        }

        /*artık ikinci sayfanın window handle değerini biliyoruz
        rahatlıkla sayfalar arası geçiş yapabiliriz
         */

driver.switchTo().window(ikincisayfaWindowHandleDeğeri);

        //Açılan yeni pencerenin sayfa başlığının (title) "New Window" olduğunu doğrulayın.

        String expectedİkinciTitle="New Window";
        String actualikinciTitle=driver.getTitle();
        Assert.assertEquals(expectedİkinciTitle,actualikinciTitle);

        //sayfadaki textin "New Window" olduğunu doğrulayın.

        WebElement ikincisayfayazıelementi=driver.findElement(By.xpath("//h3"));
        String expectedikinciyazı="New Window";
        String actualİkinciyazı=ikincisayfayazıelementi.getText();
        Assert.assertEquals(expectedikinciyazı,actualİkinciyazı);

        //bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu doğrulayın

        driver.switchTo().window(ilksayfaWindowHandleDeğeri);
        String expectedilksayfabaşlığı="The Internet";
        String actualilksayfabaşlığı=driver.getTitle();
        Assert.assertEquals(expectedilksayfabaşlığı,actualilksayfabaşlığı);
    }
}
