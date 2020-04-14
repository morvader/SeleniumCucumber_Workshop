package pages.openCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CartPage {
    private WebDriver driver;

    By cartItem = By.cssSelector("#content > form > div > table > tbody > tr");
    By cartItemName = By.cssSelector("#content > form > div > table > tbody > tr > td:nth-child(2) > a");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getNItems() {
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem));

        return driver.findElements(cartItem).size();
    }

    public ArrayList<String> getItemNames() {
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem));

        return (ArrayList<String>) driver.findElements(cartItemName).stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
