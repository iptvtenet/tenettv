package maintests;

import org.testng.annotations.*;
import utils.RetryAnalyzer;
import utils.TestListener;
import utils.Tools;

@Listeners(TestListener.class)
public class Tests {

    BodyTests body = new BodyTests();
    Tools tools = new Tools();


    @DataProvider(name = "negativeAuthentication")

    public static Object[][] credentials() {

        return (Object[][]) Variables.data;

    }


    @Test(groups = "positiveLogin")
    public void testPositiveLogin() throws InterruptedException {
        body.positiveLogin();
    }


    @Test(groups = "positiveLogin", priority = 1, retryAnalyzer = RetryAnalyzer.class, dependsOnMethods = "testPositiveLogin")
    public void testAboutProject() throws InterruptedException {
        body.aboutProject();
    }

    @Test(groups = "negativeLogin", dataProvider = "negativeAuthentication", threadPoolSize = 3)
    public void testNegativeLogin(String login, String password) throws InterruptedException {
        body.negativeLogen(login, password);
    }


    @BeforeMethod
    public void setDriver() {
        tools.setUp();
    }

    @AfterMethod
    public void quiteDriver() throws InterruptedException {
        tools.finish();
    }

}
