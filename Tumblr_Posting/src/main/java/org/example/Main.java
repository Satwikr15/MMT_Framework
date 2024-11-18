package org.example;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//
//        WebDriver driver=new ChromeDriver();
//        driver.get("https://www.tumblr.com/");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath(" //button[2][@class='TRX6J CxLjL qjTo7 IMvK3']//span[text()='Log in']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[@aria-label='Continue with email']")).click();
//        driver.findElement(By.name("email")).sendKeys("marketing@kanerika.com");
//        driver.findElement(By.xpath("//button/span[@class='EvhBA' and text()='Next']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.name("password")).sendKeys("Hyderabad@2024");
//        driver.findElement(By.xpath("//button[@class='TRX6J CxLjL qjTo7 CguuB qNKBC']/span[text()='Log in']")).click();
        Main obj=new Main();
        obj.ReadExcel("User_credentials",1,0);
        obj.ReadExcel("User_credentials",1,1);
        obj.WriteExcel("User_credentials",1,2,"IN");

    }
    public void ReadExcel(String sheetname,int rno,int cno){
        String Data="";
        String filepath="C://Users//KSPL//Desktop//TestData.xlsx";
        try{
            FileInputStream fileInputStream=new FileInputStream(filepath);
            Workbook wb=WorkbookFactory.create(fileInputStream);
            Sheet s =wb.getSheet(sheetname);
            Row r= s.getRow(rno);
            Cell c=r.getCell(cno);
             Data =c.getStringCellValue();
             System.out.println(Data);

        } catch (Exception e) {
            System.out.println("ReadExcel catch block");
            e.printStackTrace();
        }
    }

    public void WriteExcel(String sheetname,int rno,int cno,String data){
        String Data="";
        String filepath="C://Users//KSPL//Desktop//TestData.xlsx";
        try{
            FileInputStream fileInputStream=new FileInputStream(filepath);
            Workbook wb=WorkbookFactory.create(fileInputStream);
            Sheet s =wb.getSheet(sheetname);
            Row r= s.getRow(rno);
            Cell c =r.createCell(cno);
            c.setCellValue(data);
            FileOutputStream fileOutputStream=new FileOutputStream(filepath);
            wb.write(fileOutputStream);
        } catch (Exception e) {
            System.out.println("ReadExcel catch block");
            e.printStackTrace();
        }
    }

}