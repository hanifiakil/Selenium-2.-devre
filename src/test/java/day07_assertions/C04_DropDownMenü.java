package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.crypto.KeyAgreementSpi;
import java.time.Duration;

public class C04_DropDownMenü {
    /*amazon a gidin
    dropdown dan books seçeneğini seçin
    java aratalım
    ve arama sonuçlarının java içerdiğini test edelim
     */
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
        driver.get("https://www.amazon.com");

        //dropdown dan bir option seçmek için 3 adım vardır
        //1-dropdown i locate edelim
        WebElement dropDownMenü=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //2- bir select objesi oluşturup
        //parametre olarak bir önceki adımda locate ettiğiniz ddm yi girelim
        Select select=new Select(dropDownMenü);
        //3-dropdown da var olan option lardan istediğimiz bir taneyi seçelim

        select.selectByVisibleText("Baby");
       // select.selectByIndex(3);
     //  select.selectByValue("search-alias=baby-products-intl-ship");
    //arama kutusuna biberon yazdıralım
        WebElement aramakutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramakutusu.sendKeys("biberon"+ Keys.ENTER);
        Thread.sleep(5000);

        WebElement aramasonuç=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonuçyazısı=aramasonuç.getText();
        String aranankelime="biberon";

        Assert.assertTrue(sonuçyazısı.contains(aranankelime));


    }

}
