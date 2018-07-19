
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WebDriverBase implements Variables {

    static WebDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromdriver\\chromedriver.exe");
    }

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized","--incognito");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(8, SECONDS);

        Tools.setDriver(driver);
//        BodyOfTests.setDriver(driver);
    }

    @AfterTest(alwaysRun = true)
    public void finish() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
