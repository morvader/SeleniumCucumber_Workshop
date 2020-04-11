package pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationFormPage {
    private WebDriver driver;

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.cssSelector("#login button");

    By message = By.id("flash");

    public AuthenticationFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public AuthenticationFormPage loginIncorrecto(String user, String pass) {
        loginAs(user, pass);

        return this;
    }

    public String getMessageText() {
        return driver.findElement(message).getText();
    }

    private void loginAs(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);

        driver.findElement(loginBtn).click();
    }

    public SecureAreaPage loginCorrecto(String user, String pass) {
        loginAs(user, pass);

        return new SecureAreaPage(driver);

    }
}
