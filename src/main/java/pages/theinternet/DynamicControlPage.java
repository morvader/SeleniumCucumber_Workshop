package pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlPage {
    private WebDriver driver;

    By btn = By.cssSelector("#checkbox-example button");
    By checkbox = By.cssSelector("#checkbox");
    By mensaje = By.cssSelector("#message");

    public DynamicControlPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickButton() {
        driver.findElement(btn).click();
    }

    public String getMensaje() {
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mensaje));
        return driver.findElement(mensaje).getText();
    }

    public boolean isCheckBoxPresent() {
        try {
            driver.findElement(checkbox);
            return true;
        } catch (NoSuchElementException noElement) {
            return false;
        }
    }
}
