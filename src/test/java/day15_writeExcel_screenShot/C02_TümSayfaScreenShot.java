package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_TümSayfaScreenShot extends TestBase {

    @Test
    public void tümSayfa() throws IOException {

        //amazon sayfasına gidip tüm sayfanın fotoğrafını çekelim

        driver.get("https://www.amazon.com");

        //RESİMLERİ ÜSTÜSTE KAYDETMESİN DİYE DOSYA YOLUNU DİNAMİK YAPMAK İÇİN KULLANILIR
        TakesScreenshot ts= (TakesScreenshot) driver;
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih= date.format(dtf);
        //BURAYA KADARKİ KODLAMA
        File tümsayfaResim=new File("target/ekranGörüntüleri/tümSayfa"+tarih+".jpeg");

        File geçiciResim=ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geçiciResim,tümsayfaResim);

    }
}
