package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C02_Actions extends TestBase {

    @Test
    public void test01(){
        //amazon sayfasına gidip
        driver.get("https://www.amazon.com");
        //account menüsünden create a list linkine tıklayalım

        Actions actions=new Actions(driver);
        WebElement element= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement( element).perform();

        WebElement createalist= driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
        actions.click(createalist).perform();
    }
}
