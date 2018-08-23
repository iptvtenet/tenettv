package maintests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Tools;

public class BodyTests {

    Tools tools = new Tools();


    public void positiveLogin() throws InterruptedException {
        login(Variables.login, Variables.Password);
        Assert.assertEquals("TV КАНАЛЫ", tools.myElement(By.cssSelector("#title_pazdel")).getText());
    }

    public void negativeLogen() throws InterruptedException {
        login("testFaile", "testFaile");
        Assert.assertEquals("Увы, но такая комбинация логина и пароля отсутствует.", tools.myElement(By.cssSelector(".bootstrap-dialog-message > div:nth-child(1) > p:nth-child(1)")).getText());

    }

    private void login(String login, String password) {
        tools.myElement(By.cssSelector(".loginform2")).click();
        tools.myElement(By.cssSelector("#login")).sendKeys(login);
        tools.myElement(By.cssSelector("#passw")).sendKeys(password);
        tools.myElement(By.cssSelector("#loginuser")).click();
    }

    public void aboutProject() {
        login(Variables.login, Variables.Password);
        tools.myElement(By.cssSelector("#item_0 > a:nth-child(1)")).click();
        tools.myElement(By.cssSelector(".top-menu-left > li:nth-child(2) > a:nth-child(1)")).click();
        Assert.assertEquals("TENET-TV — ВСЕ, ЧТО ЛЮБИШЬ", tools.myElement(By.cssSelector(".o-proeke-tenet-tv > h1:nth-child(1)")).getText());
    }
}
