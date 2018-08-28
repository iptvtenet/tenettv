package utils;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.util.List;

public class Reporter implements IReporter {

    TestListener listener = new TestListener();

    @Override
    public void generateReport(List<XmlSuite> list, List<ISuite> list1, String s) {
        for (int i = 0; i < listener.listReports.size(); i++) {
            System.out.println(listener.listReports.get(i));
        }
    }
}
