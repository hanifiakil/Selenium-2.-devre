package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CheckBox {
WebDriver driver;
    @Before
    public void setUp(){
        //gerekli yapıyı oluşturun ve aşağıdaki görevi tamamlayın
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
    public void test1() throws InterruptedException {
        //verilen web sayfasına gidin "https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //Checkbox1 ve Checkbox2 elementlerini locate edin
        WebElement checkbox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        //Checkbox1 seçili değilse onay kutusunu tıklayın
        Thread.sleep(3000);
        if(!checkbox1.isSelected()){
            checkbox1.click();
        }
        //Checkbox2 seçili değilse onay kutusunu tuklayın
        Thread.sleep(3000);
        if(!checkbox2.isSelected()){
            checkbox2.click();
        }
        Thread.sleep(3000);
    }

}
