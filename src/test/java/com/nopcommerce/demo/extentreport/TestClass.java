package com.nopcommerce.demo.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TestClass {

    @Test
    public void extentTest() throws IOException {

        // Create the object of Extent Report
        ExtentReports reports = new ExtentReports();
        // Spark Reporter
        ExtentSparkReporter spark = new ExtentSparkReporter("extent.html");  // HTML file will be generated

        // Report Theme , Report Title and Report Name
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("Nop Commerce");
        spark.config().setDocumentTitle("Automation");

        // Attach the spark to Report
        reports.attachReporter(spark);

        // Add System information
        reports.setSystemInfo("OS",System.getProperty("os.name"));
        reports.setSystemInfo("Java Version",System.getProperty("java.version"));
        reports.setSystemInfo("Browser","Chrome");
        reports.setSystemInfo("Browser Version","119.1.2");

        //Create the Test
        ExtentTest test = reports.createTest("Login Test").assignAuthor("Jitesh").assignCategory("Sanity");
        test.pass("Login Test Starts successfully");
        test.info("Url is loaded");
        test.info("Values entered");
        test.pass("Login Test completed successfully");

        // highlight the Step
        test.pass(MarkupHelper.createLabel("Login test completed successfully", ExtentColor.GREEN));


        ExtentTest test1 = reports.createTest("HomePage Test").assignAuthor("Param").assignCategory("Smoke");
        test1.pass("Login Test Starts successfully");
        test1.info("Url is loaded");
        test1.info("Values entered");
        test1.fail("HomePage Test completed successfully");

        test1.fail(MarkupHelper.createLabel("HomePage test completed successfully", ExtentColor.RED));

        reports.flush(); // flush the report - Unless you can call this method report will not be written the logs
        Desktop.getDesktop().browse(new File("extent.html").toURI()); // This will open the file in the default browser - desktop


    }
}
