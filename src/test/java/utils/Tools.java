package utils;


import maintests.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileNotFoundException;
import java.util.Properties;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Tools {

    private static WebDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromdriver\\chromedriver.exe");
    }

    static String password = "iptv123321";
    private final static String username = "iptvtenet@gmail.com";


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

        String subject;
        String recpients;
        try {
            Session session = getSession();
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("iptvtenet@gmail.com")); // from email
            subject = "Test :: failure" + "if need, can add a date";
            recpients = "iptvtenet@gmail.com"; // to whom email
            message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(recpients));
            message.setSubject(subject);
            // Set Subject: header field
            message.setSubject("This is the Subject Line!");
            // Now set the actual message
            message.setText("This is actual message ++++ ");
            message.setText("body of mail");
            Transport.send(message);
            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
