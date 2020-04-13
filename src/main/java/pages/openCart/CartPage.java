package pages.openCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private WebDriver driver;

    By cartItem = By.cssSelector("#content > form > div > table > tbody > tr");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getNItems() {
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem));

        return driver.findElements(cartItem).size();
    }
}
