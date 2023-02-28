package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {

    @Test
    public void readExcellTest() throws IOException {


        //dosya yolunu bir String değişkenine atayalım

        String dosyayolu="src/resources/ulkeler.xlsx";

        //FileInputStream objesi oluşturalım parametre olarak dosya yolunu girelim

        FileInputStream fis=new FileInputStream(dosyayolu);

        //Workbook objesi oluşturalım parametre olarak FileInputStream objesini girelim

        Workbook workbook= WorkbookFactory.create(fis);

        //ingilizce başkentler sütununu yazdıralım

        int sonsatır=workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonsatır);
        String satırdakiData="";

        for (int i = 0; i < sonsatır; i++) {
            satırdakiData=C03_ReadExcel.banaDataGetir(i,1);
            System.out.println(satırdakiData);

        }




    }
}
