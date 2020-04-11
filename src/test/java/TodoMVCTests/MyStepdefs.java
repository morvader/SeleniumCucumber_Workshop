package TodoMVCTests;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.todoMVC.MainReactPage;

import java.io.IOException;

import static Base.BaseTest.takeScreenshot;
import static org.testng.Assert.assertEquals;

public class MyStepdefs {
    WebDriver driver;
    MainReactPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        driver = new ChromeDriver();

        mainPage = new MainReactPage(driver);
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed())
            takeScreenshot(driver, "./screenshots", scenario.getName());
        driver.quit();
    }

    @Given("^entro en el sistema$")
    public void entroEnElSistema() {
        mainPage.navigateTo();
    }

    @Then("^la lista de elementos está vacía$")
    public void la_lista_de_elementos_está_vacía() throws Throwable {
        int elementos = mainPage.getNumberOfElements();
        assertEquals(elementos, 0, "La lista de elementos no está vacía");
    }

    @When("^añado un elemento a lista$")
    public void añadoUnElementoALista() {
        mainPage.addNewTodo("Nuevo Elemento");
    }

    @Then("^la lista tiene (\\d+) elemento$")
    public void laListaTieneElemento(int nElementos) {
        int elementos = mainPage.getNumberOfElements();
        assertEquals(elementos, nElementos, "La lista de elementos no está vacía");
    }
}
