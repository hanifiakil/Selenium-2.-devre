package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_actions extends TestBase {

    @Test
    public void test01(){
        //https://demoqa.com/droppable/ adresine gidelim

        driver.get("https://demoqa.com/droppable/");

        //"drag me" BUTONUNU TUTUP "Drop here" kutusunun üstüne bırakalım

        Actions actions=new Actions(driver);
       WebElement tutulan= driver.findElement(By.xpath("//div[@id='draggable']"));
       WebElement bırakılan= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(tutulan,bırakılan).perform();

        //"Drop here" yazısı yerine "Dropped!" olduğunu test edin

        WebElement sonuçyazısıelementi= driver.findElement(By.xpath("//*[text()='Dropped!']"));

        String expectedyazı="Dropped!";
        String actualyazı=sonuçyazısıelementi.getText();

        Assert.assertEquals(expectedyazı,actualyazı);


    }

}
