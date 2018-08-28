package utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TestListener extends TestListenerAdapter {

    static List<String> listReportsPositive = new ArrayList<String>();
    static List<String> listReportsNegative = new ArrayList<String>();

    @Override
    public void onTestSuccess(ITestResult testResult) {
        String testName = testResult.getName();
        String className = testResult.getTestClass().toString();
        String stackTrace = "";
        listReportsPositive.add(testName + " " + className + " " + stackTrace);

    }


    @Override
    public void onTestFailure(ITestResult testResult)
    {
        String testName = testResult.getName();
        String className = testResult.getTestClass().toString();
        String stackTrace = "";
        listReportsNegative.add(testName + " " + className + " " + stackTrace);
    }


}
