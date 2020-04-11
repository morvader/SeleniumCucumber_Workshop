package pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class HoversPage {

    private WebDriver driver;

    By usersLocator = By.xpath("//div[@class='figure']");
    By userInfo = By.cssSelector(".figcaption");

    public HoversPage(WebDriver driver) {
        this.driver = driver;

    }

    public HoversPage hoverUser(int userPosition) {
        final List<WebElement> usersList = driver.findElements(usersLocator);
        final WebElement user = usersList.get(userPosition);

        Actions action = new Actions(driver);
        action.moveToElement(user).perform();

        return this;
    }

    public boolean isUserCaptionDisplayed(int userPosition) {
        final List<WebElement> usersList = driver.findElements(usersLocator);
        WebElement user = usersList.get(userPosition);
        return user.findElement(userInfo).isDisplayed();
    }

    public String getUserName(int userPosition) {
        final List<WebElement> usersList = driver.findElements(usersLocator);
        WebElement user = usersList.get(userPosition);
        return user.findElement(userInfo).findElement(By.tagName("h5")).getText();
    }

}
