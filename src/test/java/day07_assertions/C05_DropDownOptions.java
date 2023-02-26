package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptions {

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
        //amazon anasayfaya gidip
        driver.get("https://www.amazon.com");
       // dropdown menüden books u seçelim
        WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Books");
      //seçtiğimiz option ı yazdıralım
        /*bir dropdown ile çalışırken, son seçilen optiona ulaşmak isterseniz
        select.getFirstSelectedOption() method unu kullanmalısınız
        bu method bize webelement döndürür
        üzerindeki yazıyı yazdırmak için getText() unutulmalıdır*/
        System.out.println(select.getFirstSelectedOption().getText());

      // dropdown daki opsiyonların toplam sayısının 20 olduğunu test edin
        List<WebElement> optionsList=select.getOptions();

        int actualOptionsayısı= optionsList.size();
        int expectedOptionsayısı=28;

        Assert.assertEquals(expectedOptionsayısı,actualOptionsayısı);


    }
    }
