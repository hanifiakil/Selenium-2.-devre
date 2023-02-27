package day13_cookies_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_WebTables extends TestBase {

    @Test
    public void dinamikYazıcı() {

        //önceki class daki adrese gidip giriş yap metodunu kullanarak sayfaya giriş yapın
        //input olarak verilen satır sayısı ve sütun satası na sahip
        //cell deki text i yazdırın

        int satır=2;
        int sütun=5;

        girişyap();

        WebElement arananCell=driver.findElement(By.xpath("//tbody//tr["+satır+"]//td["+sütun+"]"));
        System.out.println(arananCell.getText());

    }
    public  void girişyap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//button[@class='secondary-button small-link']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
        driver.findElement(By.linkText("Log in")).click();
        Actions actions=new Actions(driver);
        WebElement username= driver.findElement(By.xpath("//input[@class='form-control required']"));
        actions.click(username)
                .sendKeys("manager")
                .sendKeys(Keys.TAB)
                .sendKeys("Manager1!")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
    }
}
