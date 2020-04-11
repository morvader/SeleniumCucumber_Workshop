package pages.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScrollingPage {

    public final String URL = "https://formy-project.herokuapp.com/scroll";
    private WebDriver driver;

    By fullname = By.id("name");
    By date = By.id("date");

    public ScrollingPage(WebDriver driver) {
        this.driver = driver;
    }

    public ScrollingPage navigateTo() {
        driver.get(URL);
        return this;
    }

    public void setDate(String fecha) {
        driver.findElement(date).sendKeys(fecha);
    }

    public void setName(String name) {
        driver.findElement(fullname).click();
        driver.findElement(fullname).sendKeys(name);
    }

    public String getDate() {

        return driver.findElement(date).getAttribute("value");
    }

    public String getName() {
        return driver.findElement(fullname).getAttribute("value");
    }
}
