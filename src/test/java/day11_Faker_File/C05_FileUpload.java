package day11_Faker_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //https://the-internet.herokuapp.com/upload adresine gidelim

        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalım

        //yüklemek istediğiniz dosyayı seçelim

/*bu işlem selenium ile yapma imkanımız yok çünkü web tabanlı bir uygulama değil
bu durumda sendKeys() imdadımıza yetişir
eğer chooseFile butonuna var olan bir dosyanın dosya yolunu yollarsanız
seçme işlemi otamatik olarak yapılmış olacaktır
 */

       // 1. adım choaseFİLE BUTONUNU LOCATE EDELİM
        WebElement dosyaSeçButonu= driver.findElement(By.xpath("//input[@id='file-upload']"));

        //2. adım yüklenecek dosyanın dosya yolunu oluşturalım
        String farklıkısım=System.getProperty("user.home");
        String ortakkısım="//Desktop//text.txt";// masa üzerindeki dosyamızı yollayacağız
        String yüklenecekDosya=farklıkısım+ortakkısım;

        //3. adım sendKeys ile dosya yolunu, seçme butonuna yollayalım
        dosyaSeçButonu.sendKeys(yüklenecekDosya);


        //upload butonuna basalım

        driver.findElement(By.xpath("//input[@class='button']")).click();

        //"File Uploaded!" textinin görüntülendiğini test edelim.

        WebElement yazıElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yazıElementi.isDisplayed());
        Thread.sleep(5000);
    }
}
