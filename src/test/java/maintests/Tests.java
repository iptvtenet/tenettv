package maintests;

import org.testng.annotations.*;
import utils.Tools;

public class Tests {


    BodyTests body = new BodyTests();
    Tools tools = new Tools();


    @Test(groups = "positiveLogin")
    public void testPositiveLogin() throws InterruptedException {
        body.positiveLogin();
    }


    @Test(groups = "positiveLogin", priority = 1)
    public void testAboutProject() throws InterruptedException {
        body.aboutProject();
    }

    @Test(groups = "negativeLogin")
    public void testNegativeLogin() throws InterruptedException {
        body.negativeLogen();
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
