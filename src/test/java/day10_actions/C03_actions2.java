package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_actions2 extends TestBase {

    @Test
    public void test01(){
        //https://the-internet.herokuapp.com/context_menu sitesine gidelim

        driver.get("https://the-internet.herokuapp.com/context_menu");

       String birincihandledeğeri= driver.getWindowHandle();

        //çizili alan üzerine sağ click yapalım

        Actions actions=new Actions(driver);
        WebElement sağclick= driver.findElement(By.id("hot-spot"));
        actions.contextClick(sağclick).perform();

        //Alert te çıkan yazının "You selected a context menu" olduğunu test edelim

        String expectedYazı="You selected a context menu";
        String actualYazı=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazı,actualYazı);

        //tamam diyerek alert i kapatalım

        driver.switchTo().alert().accept();

        //Elemental Selenium linkine tıklayalım

        driver.findElement(By.xpath("//a[@target='_blank']")).click();

        Set<String> tümhandleDeğerleri=driver.getWindowHandles();
        String ikincihandleDeğeri="";
        for (String each: tümhandleDeğerleri
        ) {if (!each.equals(birincihandledeğeri))
        {ikincihandleDeğeri=each;}

        }
        driver.switchTo().window(ikincihandleDeğeri);
        System.out.println(tümhandleDeğerleri);
        System.out.println("2."+ikincihandleDeğeri);
        //Açılan sayfada h1 tağında "Elemental Selenium" yazdığını test edelim


       WebElement elementalselenium= driver.findElement(By.xpath("(//*[text()='Elemental Selenium'])"));
        String expectedtest="Elemental Selenium";
        String actualtest=elementalselenium.getText();
        Assert.assertEquals(expectedtest,actualtest);



    }
}
