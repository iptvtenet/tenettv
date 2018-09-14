package utils;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.util.List;

public class Reporter extends Tools implements IReporter {

    TestListener listener = new TestListener();
    StringBuilder positive;
    StringBuilder negative;


    @Override
    public void generateReport(List<XmlSuite> list, List<ISuite> list1, String s) {
        for (int i = 0; i < listener.listReportsPositive.size(); i++) {
            System.out.println(listener.listReportsPositive.get(i));
            positive.append(listener.listReportsPositive.get(i));
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
                negative.append(listener.listReportsNegative.get(i));
            }
        }
        try {
            sendMail(positive.toString(), negative.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}
