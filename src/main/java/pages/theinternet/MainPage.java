package pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public AuthenticationFormPage goToAuthenticationFormPage() {
        clickLink("Form Authentication");
        return new AuthenticationFormPage(driver);
    }

    public DropdownPage goToDropDownPage() {
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public HoversPage goToHoverPage() {
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public DynamicControlPage goToDynamicControlPage() {
        clickLink("Dynamic Controls");
        return new DynamicControlPage(driver);
    }

    public HandleWindowsPage goToHandleWindowsPage() {
        clickLink("Multiple Windows");
        return new HandleWindowsPage(driver);
    }

    private void clickLink(String link) {
        driver.findElement(By.linkText(link)).click();
    }

}
