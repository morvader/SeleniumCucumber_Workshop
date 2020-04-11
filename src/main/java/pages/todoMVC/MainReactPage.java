package pages.todoMVC;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MainReactPage {
    WebDriver driver;

    String URL = "http://todomvc.com/examples/react/";

    By newTodo = By.cssSelector(".new-todo");
    By listItems = By.cssSelector(".todo-list li");

    public MainReactPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainReactPage navigateTo() {
        driver.get(URL);
        return this;
    }

    public MainReactPage addNewTodo(String item) {
        driver.findElement(newTodo).sendKeys(item + Keys.ENTER);
        return this;
    }

    public int getNumberOfElements() {
        return driver.findElements(listItems).size();
    }


}
