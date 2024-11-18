package MMT_Objects.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class extentreports {
    public static void main(String[] args) throws IOException {
        ExtentReports extentReports=new ExtentReports();
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("target/extent-report.html");
        extentReports.attachReporter(extentSparkReporter);


        ExtentTest test1= extentReports.createTest("Test 1");
        test1.pass("this is passed");

        extentReports.createTest("Test2").log(Status.FAIL,"This is failed").log(Status.SKIP,"This is Skipped");

        extentReports.flush();
        Desktop.getDesktop().browse(new File("target/extent-report.html").toURI());

    }
}
