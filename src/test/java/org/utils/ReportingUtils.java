package org.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ReportingUtils {

    public static ExtentReports reports;

    public static ExtentTest extentTest;

    public static void setUpReporter() {
        reports = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/suiteReport.html");
        reporter.config().setReportName("Facebook Tests");
        reporter.config().setDocumentTitle("QA Report");
        reports.attachReporter(reporter);
    }

    public static void createTest(String testName) {
        extentTest = reports.createTest(testName);
    }

    public static void addStep(String message, WebDriver driver) throws IOException {
        extentTest.info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotAsString(driver)).build());
    }

    public static String getScreenshotAsString(WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        byte[] byteArray = FileUtils.readFileToByteArray(file);
        return Base64.getEncoder().encodeToString(byteArray);

    }

    public static void flushReport() {
        reports.flush();
    }
}
