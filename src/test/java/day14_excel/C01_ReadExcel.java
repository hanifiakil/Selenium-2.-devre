package day14_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {
        //dosya yolunu bir String değişkenine atayalım

        String dosyayolu="src/resources/ulkeler.xlsx";

        //FileInputStream objesi oluşturalım parametre olarak dosya yolunu girelim

        FileInputStream fis=new FileInputStream(dosyayolu);

        //Workbook objesi oluşturalım parametre olarak FileInputStream objesini girelim

        Workbook workbook= WorkbookFactory.create(fis);

        //Sheet objesi oluşturun

        Sheet sheet= workbook.getSheet("Sayfa1");

        //row objesi oluşturalım

        Row row=sheet.getRow(3);

        //cell objesi oluşturalım

        Cell cell= row.getCell(3);

        //3.index deki satırın 3. index indeki datanın Cezayir olduğunu test edin

        String expectedData="Cezayir";
        String actualData=cell.toString();
        Assert.assertEquals(expectedData,actualData);
        //yada
        Assert.assertEquals(expectedData,cell.getStringCellValue());

        System.out.println(cell);
    }
}
