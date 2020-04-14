package pages.openCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ResultsPage {
    private WebDriver driver;

    By elementPrice = By.cssSelector(".product-grid .caption .price");
    By elementName = By.cssSelector(".product-grid .caption h4");
    By addToCartBtn = By.cssSelector(".product-grid .button-group button:first-child");

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getElementPrice(int index) {
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementPrice));

        return driver.findElements(elementPrice).get(index).getText();
    }

    public String getElementName(int index) {
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementName));

        return driver.findElements(elementName).get(index).getText();
    }

    public ArrayList<String> getAllElementNames() {
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementName));

        return (ArrayList<String>) driver.findElements(elementName).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public ResultsPage addElementToCart(String item) {
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementName));

        int pos = getAllElementNames().indexOf(item);

        driver.findElements(addToCartBtn).get(pos).click();

        return this;
    }


}
