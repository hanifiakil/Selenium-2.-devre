package day11_Faker_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    @Test
    public void name() throws InterruptedException {


        //https://the-internet.herokuapp.com/download adresine gidelim

        driver.get("https://the-internet.herokuapp.com/download");

        //code.txt dosyasını indirelim

        driver.findElement(By.xpath("//a[text()='TextDoc.txt']")).click();
Thread.sleep(1000);
        //dosyanın başarıyla indirilip indirilmediğini test edelim

        String adres=System.getProperty("user.home")+"\\Downloads\\TextDoc.txt";
        Assert.assertTrue(Files.exists(Paths.get(adres)));
    }
}