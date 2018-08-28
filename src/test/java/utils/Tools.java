package utils;


import maintests.Variables;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileNotFoundException;
import java.util.Properties;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Tools {

    private static WebDriver driver;

    private final static String username = "808nps@gmail.com";
    static String password = "droplles1_S1";
    static Multipart multipart = new MimeMultipart();


    public static WebElement myElement(By by) {
        WebElement element = driver.findElement(by);
        return element;
    }

    public static WebElement clearAndFill(By selector, String data) {
        WebElement element = driver.findElement(selector);
        element.clear();
        element.sendKeys(data);

        return element;
    }


    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromdriver\\chromedriver.exe");
    }


    public static void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--incognito");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Variables.Url);
        driver.manage().timeouts().implicitlyWait(8, SECONDS);

    }

    public static void finish() throws InterruptedException {
        Thread.sleep(200);
        driver.quit();
    }

    private static Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        return Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
    }


    public static void sendMail() throws FileNotFoundException, javax.mail.MessagingException {
       // password = FilenameUtils.normalize("G:\\QA\\login.txt").toString(); // my, need test!
        String subject;
        String recpients;
        try {
           // if (multipart.getCount() != 0)
            if (true)
            {
                Session session = getSession();
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress("808nps@gmail.com")); // from email
                // subject = "Test :: failure"+ EnvironmentHelper.getCurrentDate();
                subject = "Test :: failure" + "тут добавлялась дата";
                recpients = "808nps@gmail.com"; // to whom email
                message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(recpients));
                message.setSubject(subject);
                // Set Subject: header field
                message.setSubject("This is the Subject Line!");
                // Now set the actual message
                message.setText("This is actual message ++++ TEST");
              //  message.setContent(multipart);
                message.setText("body of mail");
//                System.out.println("Sending letter ...");
                Transport.send(message);
                System.out.println("Done");
            } else {
                System.out.println("well done");
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
