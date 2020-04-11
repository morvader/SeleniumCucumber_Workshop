package pages.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownButtonPage {

    public final String URL = "https://formy-project.herokuapp.com/dropdown";
    private WebDriver driver;

    By btn = By.id("dropdownMenuButton");
    By menuItemShow = By.cssSelector(".dropdown-menu.show a");

    public DropDownButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    public DropDownButtonPage navigateTo() {
        driver.get(URL);
        return this;
    }

    public DropDownButtonPage clickButton() {
        driver.findElement(btn).click();
        return this;
    }

    public int getMenuSize() {
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuItemShow));
        return driver.findElements(menuItemShow).size();
    }

    public void clickOnElement(String element) {
        clickButton();
        driver.findElement(By.linkText(element)).click();
    }
}
