package TheInternetTests;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;
import pages.theinternet.MainPage;

public class BaseTestTestTheInternet extends BaseTest {

    protected MainPage mainPage;

    @BeforeMethod
    public void setup() {
        super.setup();
        driver.get("https://the-internet.herokuapp.com/");

        mainPage = new MainPage(driver);
    }
}
