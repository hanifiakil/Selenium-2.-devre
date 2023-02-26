package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboarActions extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //facebook anasayfaya gidip

        driver.get("https://www.facebook.com");

        //yeni kayıt oluştur butonuna basın

        driver.findElement(By.xpath("(//div[@class='_6ltg'])[2]")).click();

        //isim kutusunu locate edip

        Actions actions=new Actions(driver);
        WebElement isimkutusu=driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        actions.click(isimkutusu)
                        .sendKeys("Rukiye")
                .keyDown(Keys.TAB)
                        .sendKeys("AKİL")
                .keyDown(Keys.TAB)
                        .sendKeys("rukiye19@gmail.com")
                .keyDown(Keys.TAB)
                        .sendKeys("rukiye19@gmail.com")
                .keyDown(Keys.TAB)
                        .sendKeys("71047104Hh")
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



        Thread.sleep(5000);

        //geriye kalan alanları TAB ile dolaşarak formu doldurun
    }
}
