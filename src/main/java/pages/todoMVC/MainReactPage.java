package pages.todoMVC;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainReactPage {
    WebDriver driver;

    String URL = "http://todomvc.com/examples/react/";

    By newTodo = By.cssSelector(".new-todo");
    By listItems = By.cssSelector(".todo-list li");
    By completedListItems = By.cssSelector(".todo-list .completed");
    By completeItemBtn = By.cssSelector(".toggle");
    By completedListBtn = By.linkText("Completed");

    public MainReactPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainReactPage navigateTo() {
        driver.get(URL);
        return this;
    }

    public MainReactPage addNewTodo(String item) {
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(newTodo));

        driver.findElement(newTodo).sendKeys(item + Keys.ENTER);
        return this;
    }

    public int getNumberOfElements() {
        return driver.findElements(listItems).size();
    }

    public int getCompletedlistSize() {
        return driver.findElements(completedListItems).size();
    }

    public String getListElementName(int nElement) {
        return driver.findElements(listItems).get(nElement - 1).getText();
    }

    public MainReactPage completeElement(int nElement) {
        driver.findElements(listItems).get(nElement - 1)
                .findElement(completeItemBtn).click();
        return this;
    }

    public MainReactPage clickCompletedBtn() {
        driver.findElement(completedListBtn).click();
        return this;
    }

    public boolean isElementCompleted(int nElement) {
        return driver.findElements(listItems).get(nElement - 1).getAttribute("class").equals("completed");
    }

}
