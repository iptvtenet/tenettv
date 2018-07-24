package maintests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Tools;
import utils.Variables;

import static java.util.concurrent.TimeUnit.SECONDS;


public class Registration {

    public static WebDriver driver;

    Tools tools = new Tools();

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromdriver\\chromedriver.exe");
    }


    @Test(groups = "positiveLogin")
    public void registration() throws InterruptedException {
        setUp();
        driver.findElement(By.cssSelector(".loginform2")).click();
        driver.findElement(By.cssSelector("#login")).sendKeys(Variables.login);
        driver.findElement(By.cssSelector("#passw")).sendKeys(Variables.Password);
        driver.findElement(By.cssSelector("#loginuser")).click();
        Assert.assertEquals("TV КАНАЛЫ", tools.myElement(By.cssSelector("#title_pazdel")).getText());

        finish();
    }

    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--incognito");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Variables.Url);
        driver.manage().timeouts().implicitlyWait(8, SECONDS);

        utils.Tools.setDriver(driver);

    }

    public void finish() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
