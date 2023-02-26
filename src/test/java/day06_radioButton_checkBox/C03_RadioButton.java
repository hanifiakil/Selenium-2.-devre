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

public class C03_RadioButton {
    //gerekli yapıyı oluşturun ve aşağıdaki görevi oluşturun
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
    public void test1() throws InterruptedException {
    //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
    //cookies i kabul edin//türkiye de gerek yok
    //"create on account" button una basın
        driver.findElement(By.xpath("//*[text()='Yeni hesap oluştur']")).click();
    //"radio buttons" elementlerini locate edin
        WebElement kızradio=driver.findElement(By.xpath("//input[@value='1']"));
        WebElement erkekradio=driver.findElement(By.xpath("//input[@value='2']"));
        WebElement özelradio=driver.findElement(By.xpath("//input[@value='-1']"));
    //seçili değilse cinsiyet butonundan size uygun olanı seçin
        Thread.sleep(3000);
        if (!erkekradio.isSelected()){
            erkekradio.click();
        }
        Thread.sleep(3000);

    }
}
