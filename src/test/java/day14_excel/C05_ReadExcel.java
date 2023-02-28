package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {

    @Test
    public void readExcelTesti() throws IOException {
        //dosya yolunu bir String değişkenine atayalım

        String dosyayolu="src/resources/ulkeler.xlsx";

        //FileInputStream objesi oluşturalım parametre olarak dosya yolunu girelim

        FileInputStream fis=new FileInputStream(dosyayolu);

        //Workbook objesi oluşturalım parametre olarak FileInputStream objesini girelim

        Workbook workbook= WorkbookFactory.create(fis);

        //sayfa 2ye gidin
        //satır sayısının 26 kullanılan satır sayısının ise 13 olduğunu test edin

        int sonsatırindex=workbook.getSheet("Sayfa2")
                .getLastRowNum();
        int expectedSatırSayısı=26;
        Assert.assertEquals(expectedSatırSayısı,sonsatırindex+1);

        int kullanılansatırindex=workbook.getSheet("Sayfa2")
                .getPhysicalNumberOfRows();
        int expectedkullanılansatırsayısı=14;

        Assert.assertEquals(expectedkullanılansatırsayısı,kullanılansatırindex+1);


    }
}
