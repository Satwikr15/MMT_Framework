package org.example;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class ReadWrite_SEO {
    String filepath="C://Users//KSPL//Desktop//SEO_Trails.xlsx";
    public static void main(String[] args) {
        ReadWrite_SEO readWriteSeo=new ReadWrite_SEO();
        //System.out.println(readWriteSeo.getValue("Sheet1",3,"Blog URL "));
        readWriteSeo.putValue("Sheet1",3,"Pinterest","https://www.uploaded.com");
        //System.out.println(readWriteSeo.putValue("Sheet1",3,"Pinterest","https://www.uploaded.com"));
    }
    public String getValue(String sheetname, int SNo, String columnName){
        String data="";
        try{
            FileInputStream fileInputStream=new FileInputStream(filepath);
            Workbook wb= WorkbookFactory.create(fileInputStream);
            Sheet s=wb.getSheet(sheetname);
            Row headerrow = s.getRow(0);
            int columnIndex = 0;
            for (Cell cell : headerrow) {
                if (cell.getStringCellValue().equalsIgnoreCase(columnName.trim())) {
                    columnIndex = cell.getColumnIndex();
                    break;
                }
            }
            Row targetRow = s.getRow(SNo);
            Cell targetCell= targetRow.getCell(columnIndex);
            data = targetCell.getStringCellValue();
        }
        catch (Exception E){
            E.printStackTrace();
        }
        return data;
    }

    public String putValue(String sheetname, int SNo, String columnName,String URL){
        String value="";
        try{
            FileInputStream fileInputStream=new FileInputStream(filepath);
            Workbook wb=WorkbookFactory.create(fileInputStream);
            Sheet s=wb.getSheet(sheetname);

            Row headerrow = s.getRow(0);
            int columnIndex = -1;
            for (Cell cell : headerrow) {
                if (cell.getStringCellValue().equalsIgnoreCase(columnName.trim())) {
                    columnIndex = cell.getColumnIndex();
                    break;
                }
            }
            Row targetRow = s.getRow(SNo);
            Cell targetCell= targetRow.getCell(columnIndex);
            targetCell.setCellValue(URL);
            FileOutputStream fileOutputStream=new FileOutputStream(filepath);
            wb.write(fileOutputStream);

            return "valued updated !!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
