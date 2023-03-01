package day15_writeExcel_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JavaS_ExecutorTest extends TestBase {

    @Test
    public void JSExecutorTest() throws InterruptedException {

        //amazon a gidelim

        driver.get("https://www.amazon.com");

        //aşagıdaki sign in butonu görününceye kadar js ile scrool yapalım

        JavascriptExecutor jse=(JavascriptExecutor) driver;
        WebElement signInbutonu= driver.findElement(By.xpath("(//a[@class='a-link-normal see-more truncate-1line'])[15]"));
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView();",signInbutonu);
        Thread.sleep(3000);
        //sign in butonuna js ile click yapalım
        jse.executeScript("arguments[0].click();",signInbutonu);

        Thread.sleep(3000);
    }
}
