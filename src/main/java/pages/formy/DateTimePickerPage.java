package pages.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimePickerPage {
    public final String URL = "https://formy-project.herokuapp.com/datepicker";
    private WebDriver driver;

    By datepicker = By.id("datepicker");
    String diaMes_xpath = "//*[@class='datepicker-days']//td[text()='%d']";

    public DateTimePickerPage(WebDriver driver) {
        this.driver = driver;
    }

    public DateTimePickerPage navigateTo() {
        driver.get(URL);
        return this;
    }

    public void setDateInput(String date) {
        driver.findElement(datepicker).sendKeys(date);
    }

    public void setDateClick(int dia) {
        String selector = String.format(diaMes_xpath, dia);
        driver.findElement(datepicker).click();
        driver.findElement(By.xpath(selector)).click();
    }

    public LocalDate getDate() {
        final String dateString = driver.findElement(datepicker).getAttribute("value");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
        return LocalDate.parse(dateString, formatter);


    }
}
