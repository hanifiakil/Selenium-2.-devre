package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        //excel dosyasındaki tüm verileri clasımıza alıp
        //bir java objesine store edelim
        //böylece her seferinde excel
        Map<String,String> ülkeisimleriMab=new HashMap<>();

        //dosya yolunu bir String değişkenine atayalım

        String dosyayolu="src/resources/ulkeler.xlsx";

        //FileInputStream objesi oluşturalım parametre olarak dosya yolunu girelim

        FileInputStream fis=new FileInputStream(dosyayolu);

        //Workbook objesi oluşturalım parametre olarak FileInputStream objesini girelim

        Workbook workbook= WorkbookFactory.create(fis);

        int sondatırİndex=workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i < sondatırİndex; i++) {
            //key i. satırdaki 0. indexdeki data olacak
            String key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            //value i. satırın 1,2 ve 3. indexdeki dataları olacak
            String value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    +", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    +", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ülkeisimleriMab.put(key,value);
            System.out.println(key+", "+value);
        }
        System.out.println(ülkeisimleriMab);

        //Listede Ghana olduğunu test edelim
        Assert.assertTrue(ülkeisimleriMab.keySet().contains("Ghana"));
    }
}
