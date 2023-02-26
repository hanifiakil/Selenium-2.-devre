package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboarACTİONS extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));

        //önce arama kutusuna click yapıp
        //sonra harf harf Nutella yazısını yazdıralım
        //sonra da ENTER tuşuna basalım

        Actions actions=new Actions(driver);

        actions.click(aramakutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("n")
                .keyUp(Keys.SHIFT)
                .sendKeys("u")
                .sendKeys("t")
                .sendKeys("e")
                .sendKeys("l")
                .sendKeys("l")
                .sendKeys("a")
                .sendKeys(Keys.ENTER)
                        .perform();



        Thread.sleep(5000);
    }
}
