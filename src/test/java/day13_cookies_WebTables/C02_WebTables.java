package day13_cookies_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    @Test
    public void webTablesTest01() {

        //login()metod u oluşturun ve oturum açın
        //https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //     Username : manager
        //     Password : Manager1!
        girişyap();

        //table() metod u oluşturun
        //   tüm table body sinin boyutunu(sütun sayısını) bulun

        List<WebElement> tümsütunsayısı=driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("tüm sütun sayısı : " + tümsütunsayısı.size());

        //   tabledaki tüm bady ı ve başlıkları (headers) konsol da yazdırın

        WebElement tümbady=driver.findElement(By.xpath("//tbody"));

       //tüm bady i bir string olarak yazdırmak isterseniz
        //bady webElementini locate edip getText() method u ile yazdırabiliriz

        System.out.println(tümbady.getText());

        //printRows() metodu oluşturun//tr
        //     table bady sinde bulunan toplam satır(row) sayısını bulun

        List<WebElement> satırlarlistesi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("bady sayısı : " + satırlarlistesi.size());

        //     table bady sinde bulunan satırları(rows) konsol da yazdırın   ****satır satır yazıldığından dolayı for each kullandık****yukarıdan farklı olarak

        for (WebElement each:satırlarlistesi
             ) {
            System.out.println(each.getText());

        }

        //     4. satırdaki(row) elementleri konsolda yazdırın

        List<WebElement> celllist=driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each:celllist
             ) {
            System.out.println(each.getText());

        }
        //email başlığındaki tüm elementleri(sütun)konsolda yazdırın

        List<WebElement> başlıklarlistesi=driver.findElements(By.xpath("//thead//tr[1]//th"));

        int emailsütunNo=0;
        for (int i=0; i < başlıklarlistesi.size() ; i++){
            if (başlıklarlistesi.get(i).getText().equals("Email")){
                emailsütunNo=i;
            }
        }
        List<WebElement> emailsütunelementler=
                driver.findElements(By.xpath("//tbody//td["+(emailsütunNo+1)+"]"));
        for (WebElement each:emailsütunelementler          //tbody//td[3]
             ) {
            System.out.println(each.getText());

        }
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
