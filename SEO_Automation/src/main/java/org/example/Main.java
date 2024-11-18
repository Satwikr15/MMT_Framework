package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        try {
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.tumblr.com/");
            driver.manage().window().maximize();
            Thread.sleep(2000);
            driver.findElement(By.xpath(" //button[2][@class='TRX6J CxLjL qjTo7 IMvK3']//span[text()='Log in']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@aria-label='Continue with email']")).click();
            driver.findElement(By.name("email")).sendKeys("marketing@kanerika.com");
            driver.findElement(By.xpath("//button/span[@class='EvhBA' and text()='Next']")).click();
            Thread.sleep(2000);
            driver.findElement(By.name("password")).sendKeys("Hyderabad@2024");
            driver.findElement(By.xpath("//button[@class='TRX6J CxLjL qjTo7 CguuB qNKBC']/span[text()='Log in']")).click();
            Thread.sleep(2000);
//            driver.findElement(By.xpath("//a[@class='fvSXi ML6ef']")).click();
//            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@aria-label='Text'] ")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//h1[@role='document']")).sendKeys("chat gpt");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//p[@aria-multiline='true']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[@class='EvhBA imageButton']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@class='TRX6J MD5Ec C_g5d']")).click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}