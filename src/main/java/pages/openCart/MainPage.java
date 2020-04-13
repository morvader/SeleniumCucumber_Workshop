package pages.openCart;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    WebDriver driver;

    String URL = "http://opencart.abstracta.us/index.php";


    By searchItem = By.name("search");
    By cartButton = By.cssSelector("#cart > button");

    By viewCartBtn = By.cssSelector("#cart > ul > li:nth-child(2) a:nth-child(1)");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage navigateTo() {
        driver.get(URL);
        return this;
    }

    public ResultsPage searchItem(String item) {
        driver.findElement(searchItem).sendKeys(item + Keys.ENTER);
        return new ResultsPage(driver);
    }

    public MainPage clickOnCart() {
        driver.findElement(cartButton).click();
        return this;
    }

    public CartPage goToCart() {
        clickOnCart();
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartBtn));

        driver.findElement(viewCartBtn).click();
        return new CartPage(driver);
    }


}
