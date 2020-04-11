import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Play1to50 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(600, 600));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("http://zzzscore.com/1to50/");

        String numberSelector = "//*[@id=\"grid\"]//div[text()=\"%s\"]";
        By resultsSelector = By.cssSelector(".resultContent > .level");

        WebDriverWait wait = new WebDriverWait(driver, 5);

        for (int i = 1; i <= 50; i++) {
            String xpathSelector = String.format(numberSelector, i);
            driver.findElement(By.xpath(xpathSelector)).click();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(resultsSelector));

        System.out.println("Puntuacion: " + driver.findElement(resultsSelector).getText());

        driver.quit();
    }
}
