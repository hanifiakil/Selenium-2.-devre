package day11_Faker_File;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test1() {
        System.out.println(System.getProperty("user.dir"));
        //bana içinde olduğum projenin dosya yolunu (path) verir
        System.out.println(System.getProperty("user.home"));
        //benim bilgisayarımın bana özel kısmını verir

        //C:\Users\hrbit\Downloads    indirme klasörünün yolu
        //C:\Users\hrbit\Desktop      masaüstü nün yolu

        //masa üstümüzdeki text dosyamızın varlığını test edin
        //C:\Users\hrbit\Desktop\text.txt
        String dosyayolu=System.getProperty("user.home")+"\\Desktop\\text.txt";
        System.out.println(dosyayolu);
        /*bilgisayarımızdaki bir dosyanın varlığını test etmek için
        önce o dosyaya ulaşmamız gerekir.
        java da dosyaya erişim için dosya yoluna (path) ihtiyaç vardır.

        her bilgisayarın kullanıcı adı farklı olacagından masa üstü
        dosya yoluda birbirinden farklı olacaktır
        testlerimizin tüm bilgisayarlarda çalışması için dosya yolunu
        DİNAMİK yapmak zorundayız

        bunun için
        her bilgisayarın birbirinden farklı olan yolunu bulmak için
        String farklıKısım=System.getproperty("user.home")

        herkesin bilgisayarında ortak olan kısım ise
        String ortakKısım="\Desktop\text.txt"

        String dosyayolu=farklıKısım+ortakKısım
         */

       // System.out.println(Files.exists(Paths.get(dosyayolu)));

        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));
    }
}
