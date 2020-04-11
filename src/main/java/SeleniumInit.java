import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumInit {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://duckduckgo.com/");

        final WebElement search_form_input = driver.findElement(By.name("q"));

        search_form_input.sendKeys("Selenium");

        driver.findElement(By.id("search_button_homepage")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}
