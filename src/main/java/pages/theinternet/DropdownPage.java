package pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DropdownPage {
    private WebDriver driver;

    By dropdownLocator = By.id("dropdown");
    By options = By.cssSelector("#dropdown option:not([disabled])");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getOptions() {
        List<String> valores = new ArrayList<String>();

        List<WebElement> opciones = driver.findElements(options);

        Select dropdown = new Select(driver.findElement(dropdownLocator));

        opciones = dropdown.getOptions();

        for (WebElement opcion : opciones) {
            if (opcion.getAttribute("disabled") == null)
                valores.add(opcion.getText());
        }

        return valores;
    }

    public DropdownPage selectOption(int index) {
        Select dropdown = new Select(driver.findElement(dropdownLocator));
        dropdown.selectByIndex(index);
        return this;
    }

    public String getSelectedOption() {
        Select dropdown = new Select(driver.findElement(dropdownLocator));
        return dropdown.getFirstSelectedOption().getText();
    }

}
