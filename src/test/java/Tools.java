import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tools {

    static WebDriver driver;

    public static void setDriver(WebDriver browser) {
        Tools.driver = browser;
    }

    public static WebElement myElement(By by)
    {
        WebElement element = driver.findElement(by);
        return element;
    }

    public static WebElement clearAndFill(By selector, String data) {
        WebElement element = driver.findElement(selector);
        element.clear();
        element.sendKeys(data);

        return element;
    }
}
