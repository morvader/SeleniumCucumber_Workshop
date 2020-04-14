package pages.openCart;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver;

    String URL = "http://opencart.abstracta.us/index.php";

    By searchItem = By.name("search");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage navigateTo() {
        driver.get(URL);
        return this;
    }

    public ResultsPage searchItem(String item) {
        driver.findElement(searchItem).sendKeys(item + Keys.ENTER);
        return new ResultsPage(driver);
    }


}
