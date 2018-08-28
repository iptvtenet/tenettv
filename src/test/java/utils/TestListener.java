package utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TestListener extends TestListenerAdapter {

    static List<String> listReports = new ArrayList<String>();

    @Override
    public void onTestSuccess(ITestResult testResult) {
        String testName = testResult.getName();
        String className = testResult.getTestClass().toString();
        String stackTrace = "";
        listReports.add(testName + " " + className + " " + stackTrace);

    }
}
