package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //http://zero.webappsecurity.com sayfasına gidin
driver.get("http://zero.webappsecurity.com");
        //signin butonuna tıklayın
driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        //login alanına "username" yazdırın
driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        //password alanına "password" yazdırın
driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        //sign in butonuna tıklayın
driver.findElement(By.xpath("//input[@name='submit']")).click();
driver.navigate().back();//bi geriye gittik sayfa hata verdiği için***
        //online banking menüsünden pay bills sayfasına gidin
driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        //amount kısmına yatırmak istediğiniz herhangi bir miktarı yazın
driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("500.000");
        //tarih kısmına "2023-01-29" yazdırın
driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2023-01-29");
        //pay butonuna tıklayın
driver.findElement(By.id("pay_saved_payees")).click();
        //"The payment was successfully submitted" mesajının çıktığını control edin
        WebElement testsonucu=driver.findElement(By.xpath("//div[@id='alert_content']"));
        if (testsonucu.isDisplayed()){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        driver.close();

    }
}
