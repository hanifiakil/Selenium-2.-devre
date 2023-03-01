package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_istenenWebElementSS extends TestBase {

    @Test
    public void webElementSS() throws IOException {

      //  amazon a gidip Nutella aratalım
        driver.get("https:www.amazon.com");
        WebElement aramakutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramakutusu.sendKeys("Nutella"+ Keys.ENTER);
        // ve sonuç sayısının olduğu web elementin fotoğrafını çekelim

        WebElement sonuçyazıelementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        File sonuçyazıElementSS=new File("target/ekranGörüntüleri/sonuç.jpeg");
        File geçiciresim= sonuçyazıelementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geçiciresim,sonuçyazıElementSS);




    }
}
