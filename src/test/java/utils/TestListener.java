package utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestListener extends TestListenerAdapter {

    static List<String> listReportsPositive = Collections.synchronizedList(new ArrayList<String>());
    static List<String> listReportsNegative = Collections.synchronizedList(new ArrayList<String>());

    @Override
    public void onTestSuccess(ITestResult testResult) {
        String testName = testResult.getName();
        String metodName = testResult.getTestName();
        String className = testResult.getTestClass().toString();
        String stackTrace = "";
        listReportsPositive.add(testName + " " + className + " " + metodName + " " + stackTrace);

    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        String testName = testResult.getName();
        String className = testResult.getTestClass().toString();
        String metodName = testResult.getTestName();
        String stackTrace = "";
        listReportsNegative.add(testName + " " + className + " " + metodName + " " + stackTrace);
    }


}
