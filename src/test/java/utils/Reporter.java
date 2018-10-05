package utils;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.util.List;

public class Reporter extends Tools implements IReporter {

    TestListener listener = new TestListener();
    String positive;
    String negative;


    @Override
    public void generateReport(List<XmlSuite> list, List<ISuite> list1, String s) {

        if(listener.listReportsPositive.size() < 1)
        {
            System.out.println("all will be BAD ");
        } else {
            for (int i = 0; i < listener.listReportsPositive.size(); i++) {
                System.out.println(listener.listReportsPositive.get(i));
                positive = positive + listener.listReportsPositive.get(i);
            }
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
                negative = negative + listener.listReportsNegative.get(i);
            }
        }
        try {
            sendMail(positive, negative);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}
