package maintests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.aboutProject;
import pages.start;
import pages.tvChannels;
import utils.RetryAnalyzer;
import utils.TestListener;
import utils.Tools;

@Listeners(TestListener.class)
public class Tests extends Tools {

    @DataProvider(name = "negativeAuthentication")

    public Object[][] credentials() {
        return (Object[][]) Variables.data;
    }


    @Test(groups = "positiveLogin")
    public void testPositiveLogin() {
        login(Variables.LOGIN, Variables.PASSWORD);
        WebElement test = driver.findElement(By.cssSelector(tvChannels.tvChannel));
        Assert.assertEquals(Variables.TVCHANNELS, test.getText());
    }


    @Test(groups = "positiveLogin", priority = 1, retryAnalyzer = RetryAnalyzer.class, dependsOnMethods = "testPositiveLogin")
    public void testAboutProject() {
        login(Variables.LOGIN, Variables.PASSWORD);
        driver.findElement(By.cssSelector(tvChannels.aboutTV)).click();
        driver.findElement(By.cssSelector(aboutProject.project)).click();
        Assert.assertEquals(Variables.SEETV, driver.findElement(By.cssSelector(aboutProject.textProject)).getText());
    }


    @Test(groups = "negativeLogin", dataProvider = "negativeAuthentication", threadPoolSize = 3)
    public void testNegativeLogin(String login, String password) {
        login(login, password);
        Assert.assertEquals(Variables.BADLOGIN, driver.findElement(By.cssSelector(start.badLogin)).getText());
    }


}
