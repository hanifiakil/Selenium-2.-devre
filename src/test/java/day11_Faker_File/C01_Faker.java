package day11_Faker_File;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //facebook görevini fake isimlerle yapalım

        //facebook anasayfaya gidip

        driver.get("https://www.facebook.com");

        //yeni kayıt oluştur butonuna basın

        driver.findElement(By.xpath("(//div[@class='_6ltg'])[2]")).click();

        //isim kutusunu locate edip
//geriye kalan alanları TAB ile dolaşarak formu doldurun
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String facemail=faker.internet().emailAddress();
        WebElement isimkutusu=driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        actions.click(isimkutusu)
                .sendKeys(faker.name().firstName())
                .keyDown(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .keyDown(Keys.TAB)
                .sendKeys(facemail)//üst te string oluşturarak atama yaptık
                .keyDown(Keys.TAB)
                .sendKeys(facemail)
                .keyDown(Keys.TAB)
                .sendKeys(faker.internet().password())
                .keyDown(Keys.TAB)
                .keyDown(Keys.TAB)
                .sendKeys("24")
                .keyDown(Keys.TAB)
                .sendKeys("ocak")
                .keyDown(Keys.TAB)
                .sendKeys("1992")
                .keyDown(Keys.TAB)
                .keyDown(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .keyDown(Keys.TAB)
                .keyDown(Keys.TAB)
                .keyDown(Keys.TAB)
                .keyDown(Keys.TAB)
                .keyDown(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();



        Thread.sleep(15000);
    }
}
