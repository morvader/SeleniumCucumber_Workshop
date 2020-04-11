package pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private WebDriver driver;

    By titulo = By.tagName("h2");
    By mensaje = By.id("flash");

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitulo() {
        return driver.findElement(titulo).getText();
    }

    public String getMensaje() {
        return driver.findElement(mensaje).getText();
    }
}
