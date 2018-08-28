package utils;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.util.List;

public class Reporter implements IReporter {

    TestListener listener = new TestListener();

    Tools tools = new Tools();

    @Override
    public void generateReport(List<XmlSuite> list, List<ISuite> list1, String s) {
        for (int i = 0; i < listener.listReportsPositive.size(); i++) {
            System.out.println(listener.listReportsPositive.get(i));
        }

        System.out.println("");
        System.out.println("");



        if(listener.listReportsNegative.size() < 1)
        {
            System.out.println("all will be alright");
        }
        else {
            for (int i = 0; i < listener.listReportsNegative.size(); i++) {
                System.out.println(listener.listReportsNegative.get(i));
            }
        }
        try {
            tools.sendMail();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}
