package org.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.utils.ReportingUtils;

public class ListenersClass implements ITestListener {

    public void onTestStart(ITestResult result) {

        ReportingUtils.createTest(result.getMethod().getMethodName());
    }


    public void onStart(ITestContext context) {
        ReportingUtils.setUpReporter();
    }

    public void onFinish(ITestContext context) {
        ReportingUtils.flushReport();
    }
}
