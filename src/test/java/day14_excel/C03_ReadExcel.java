package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void readExcelTesti() throws IOException {

        //input olarak verilen
        //satırNo sütunNo değerlerini parametre olarak alıp
        //o cell deki datayı String olarak bana döndüren bir method oluşturun

        int satırNo=12;
        int sütunNo=2;

        //dönen Stringin Cezayir olduğunu test edin

        String expectedData="Baku";

       String actualData= banaDataGetir(satırNo-1,sütunNo-1);//çünkü excel index ile çalışır

        Assert.assertEquals(expectedData,actualData);
    }

    public static String banaDataGetir(int satırindex, int sütunindex) throws IOException {
        String istenenData="";

        String dosyayolu="src/resources/ulkeler.xlsx";
        FileInputStream fil=new FileInputStream(dosyayolu);
        Workbook workbook= WorkbookFactory.create(fil);
        istenenData= workbook
                .getSheet("Sayfa1")
                .getRow(satırindex)
                .getCell(sütunindex)
                .toString();




        return istenenData;

    }
}
