package pages.openCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;

    By cartButton = By.cssSelector("#cart > button");

    By viewCartBtn = By.cssSelector("#cart > ul > li:nth-child(2) a:nth-child(1)");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public CartPage goToCart() {
        clickOnCart();

        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn));

        driver.findElement(viewCartBtn).click();
        return new CartPage(driver);
    }

    public void clickOnCart() {

        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));

        driver.findElement(cartButton).click();
    }
}
