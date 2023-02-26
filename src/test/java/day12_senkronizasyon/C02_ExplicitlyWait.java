package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitlyWait extends TestBase {

    @Test
    public void isEnabledTest01() {

        //https://the-internet.herokuapp.com/dynamic_controls adresine gidiniz

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Textbox in etkin olmadığını(enabled) doğrulayın

        WebElement enablekutusu= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(enablekutusu.isEnabled());

        //enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(enablekutusu));

        //"It's enable!" mesajının görüntülendiğini doğrulayın

        WebElement ıtsEnabled= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(ıtsEnabled.isDisplayed());

        //Textbox 'in etkin olduğunu(enabled) doğrulayın

        Assert.assertTrue(enablekutusu.isEnabled());
    }
}
