package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropDown {



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
    public void test01(){
        //https://the-internet.herokuapp.com/dropdown adresine gidin
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //Index kullanarak seçenek 1 i (option 1)seçin ve yazdırın
        WebElement ddm=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        //value kullanarak seçenek 2 yi (option 2)seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        //visible text(görünen metin) kullanarak seçenek 1 i(option 1)seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //tüm dropdown options ı yazdırın
        List<WebElement> tümOpsiyonlar=select.getOptions();
        for (WebElement each: tümOpsiyonlar){
            System.out.println(each.getText());
        }
        //dropdown un boyutunu bulun, dropdown da 4 öğe varsa konsolda true,değilse false yazdırın

        int dropdownBoyut=tümOpsiyonlar.size();

        if (dropdownBoyut==4){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

}
