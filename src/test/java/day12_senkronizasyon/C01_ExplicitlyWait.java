package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {

    //iki tane method oluşturun : implicitWait() , explicitWait()
    //iki metod için de aşağıdaki adımları test edin
    @Test
    public void implicitWaittest01() {

        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //remove butonuna basın

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //"İt's gone!" mesajının görüntülendiğini doğrulayın

        WebElement itsgoneyazıelementi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsgoneyazıelementi.isDisplayed());

        //add butonuna basın

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //It's back mesajının göründüğünü test edin

        WebElement itsbackyazıelementi= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsbackyazıelementi.isDisplayed());
    }

    @Test
    public void explicitlywaittest02() {
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //remove butonuna basın

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //"İt's gone!" mesajının görüntülendiğini doğrulayın

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));

       /* WebElement itsgoneyazıelementi=driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(itsgoneyazıelementi));
        Assert.assertTrue(itsgoneyazıelementi.isDisplayed());


        yazının görünür olmasını beklerken yazının locate iinin kullanmak sorun oluşturur
        çünkü henüz görülmeyen yazının locate edilmesi de mümkün olmayabilir
        (HTML kodlarını yazan farklı uygulamal yapabilir)
        bu duruma bekleme işlemi ve locate i birlikte yapmalıyız
        */

        WebElement itsgoneyazıelementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsgoneyazıelementi.isDisplayed());
        //add butonuna basın

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //It's back mesajının göründüğünü test edin

        WebElement itsbackyazıelementi= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsbackyazıelementi.isDisplayed());
    }
}
