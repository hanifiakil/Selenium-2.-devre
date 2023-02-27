package day13_cookies_WebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void Test01() {

        //amazon anasayfaya gidin

        driver.get("https://www.amazon.com");

        //tüm cookies leri listeleyin

        Set<Cookie> cookiesSet=driver.manage().getCookies();
        System.out.println(cookiesSet);

int sayaç=1;
        for (Cookie each:cookiesSet
             ) {
            System.out.println(sayaç + "inci cookies" +each);
            System.out.println("name : " + each.getName());
            System.out.println("value : " +each.getValue());
            sayaç++;
        }

        //sayfadaki cookies sayısının 5 den büyük olduğunu test edin

        int cookieSayısı=cookiesSet.size();
        Assert.assertTrue(cookieSayısı>5);

        //ismi i18n-prefs olan cookies değerinin USD olduğunu test edin

        for (Cookie each: cookiesSet
             ) {
            if(each.getName().equals("i18n-prefs")) {
                Assert.assertEquals("USD",each.getValue());
            }
        }
        //ismi "en sevdiğim cookie" ve değeri "cikolatalı" olan bir cookies oluşturun ve sayfaya ekleyin

        Cookie cookie=new Cookie("en sevdiğim cookie","çikolata");
        driver.manage().addCookie(cookie);

        cookiesSet=driver.manage().getCookies();
        System.out.println(cookiesSet);
        sayaç=1;
        for (Cookie each:cookiesSet
        ) {
            System.out.println(sayaç + "inci cookies" +each);

            sayaç++;
        }


        //eklediğiniz cookie nin sayfaya eklendiğini test edin

        Assert.assertTrue(cookiesSet.contains(cookie));//set teki cookies te benim cookie nin de var olduğunu test etti

        //ismi skin olan cookie yi silin ve silindiğini test edn

        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookiesSet.contains("skin"));

        //tüm cookie leri silin ve silindiğini test edin

        driver.manage().deleteAllCookies();
        cookiesSet=driver.manage().getCookies();
        Assert.assertTrue(cookiesSet.isEmpty());

    }
}
