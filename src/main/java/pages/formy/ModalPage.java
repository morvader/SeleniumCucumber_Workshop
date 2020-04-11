package pages.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModalPage {
    public final String URL = "https://formy-project.herokuapp.com/modal";
    private WebDriver driver;

    By btn = By.id("modal-button");

    By modalTitle = By.id("exampleModalLabel");

    public ModalPage(WebDriver driver) {
        this.driver = driver;
    }

    public ModalPage navigateTo() {
        driver.get(URL);
        return this;
    }

    public ModalPage openModal() {
        driver.findElement(btn).click();
        return this;
    }

    public String getModalTittle() {
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalTitle));

        return driver.findElement(modalTitle).getText();
    }

}
