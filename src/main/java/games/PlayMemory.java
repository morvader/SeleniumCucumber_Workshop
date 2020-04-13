package games;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PlayMemory {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        //URL
        driver.get("http://zzzscore.com/memory/en");

        //Wait counter
        By countElement = By.cssSelector(".count");
        //Cards
        By element = By.cssSelector("#grid div span");
        //Final Results
        By resultsSelector = By.cssSelector(".resultContent > .level");

        //Wait for counter to despair
        wait.until(ExpectedConditions.invisibilityOfElementLocated(countElement));

        //Get All Cards
        final List<WebElement> allElements = driver.findElements(element);

        //Get unique cards.
        //We'll use them to find matching card
        final List<WebElement> uniqueElements = allElements.stream().
                filter(distinctByKey(e -> e.getAttribute("class")))
                .collect(Collectors.toList());

        for (WebElement original : uniqueElements) {

            String elementType = original.getAttribute("class");

            //Find matching cards
            final List<WebElement> matchingCards = allElements.stream()
                    .filter(e -> e.getAttribute("class")
                            .equals(elementType))
                    .collect(Collectors.toList());

            if (!matchingCards.isEmpty()) {
                //Click on parent node (div)
                matchingCards.get(0).findElement(By.xpath("./..")).click();
                matchingCards.get(1).findElement(By.xpath("./..")).click();
            }

        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(resultsSelector));

        System.out.println("Puntuacion: " + driver.findElement(resultsSelector).getText());

        driver.quit();
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
