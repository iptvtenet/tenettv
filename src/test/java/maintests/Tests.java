package maintests;

import org.testng.annotations.*;
import utils.RetryAnalyzer;
import utils.Tools;

public class Tests {


    BodyTests body = new BodyTests();
    Tools tools = new Tools();



    @DataProvider(name = "negativeAuthentication")

    public static Object[][] credentials() {

        return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};

    }


    @Test(groups = "positiveLogin")
    public void testPositiveLogin() throws InterruptedException {
        body.positiveLogin();
    }


    @Test(groups = "positiveLogin", priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void testAboutProject() throws InterruptedException {
        body.aboutProject();
    }

    @Test(groups = "negativeLogin", dataProvider = "negativeAuthentication")
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
