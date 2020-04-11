package pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class HandleWindowsPage {
    private WebDriver driver;

    By newPageLink = By.linkText("Click Here");

    public HandleWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public NewPage openNewPage() {
        driver.findElement(newPageLink).click();
        switchWindow(1);
        return new NewPage(driver);

    }

    private void switchWindow(int index) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

    public class NewPage {
        private WebDriver driver;

        By text = By.tagName("h3");

        public NewPage(WebDriver driver) {
            this.driver = driver;
        }

        public String getText() {
            return driver.findElement(text).getText();
        }
    }
}
