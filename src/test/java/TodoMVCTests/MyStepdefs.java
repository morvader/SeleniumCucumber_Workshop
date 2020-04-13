package TodoMVCTests;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.todoMVC.MainReactPage;

import java.io.IOException;
import java.util.ArrayList;

import static Base.BaseTest.takeScreenshot;
import static org.testng.Assert.*;

public class MyStepdefs {
    WebDriver driver;
    MainReactPage mainPage;

    ArrayList<String> elementosCompletados;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        driver = new ChromeDriver();

        elementosCompletados = new ArrayList<>();

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

    @Then("^la lista tiene (\\d+) elemento$")
    public void laListaTieneElemento(int nElementos) {
        int elementos = mainPage.getNumberOfElements();
        assertEquals(elementos, nElementos, "La lista de elementos no está vacía");
    }

    @And("^marco el elemento (\\d+) como completado$")
    public void marcoElElementoComoCompletado(int nElemento) {
        String nombreElemento = mainPage.getListElementName(nElemento);
        elementosCompletados.add(nombreElemento);

        mainPage.completeElement(nElemento);
    }

    @Then("^aparece en la lista de completados$")
    public void apareceEnLaListaDeCompletados() {
        mainPage.clickCompletedBtn();

        int nElementosCompletados = mainPage.getCompletedlistSize();

        assertEquals(nElementosCompletados, elementosCompletados.size(), "El numero de elementos completados no es correcto");
    }

    @Then("^el elemento (\\d+) queda marcado como completado$")
    public void elElementoQuedaMarcadoComoCompletado(int nElemento) {
        assertTrue(mainPage.isElementCompleted(nElemento), "El elemento no se ha marcado como completado");
    }

    @When("^añado el elemento \"([^\"]*)\" a lista$")
    public void añadoElElementoALista(String newElement) throws Throwable {
        mainPage.addNewTodo(newElement);
    }

    @And("^la lista contiene el elemento \"([^\"]*)\"$")
    public void laListaContieneElElemento(String nombreElemento) throws Throwable {
        final ArrayList<String> nombreElementos = mainPage.getNombreElementos();
        assertTrue(nombreElementos.contains(nombreElemento), "La lista no contiene el elmento buscado");
    }

    @When("^elimino el elemento (\\d+)")
    public void eliminoElElemento(int nElemento) throws Throwable {
        mainPage.deleteElement(nElemento);
    }

    @Then("^el elemento \"([^\"]*)\" deja de aparecer en las listas$")
    public void elElementoDejaDeAparecerEnLasListas(String nombreElemento) throws Throwable {
        final ArrayList<String> nombreElementos = mainPage.getNombreElementos();
        assertFalse(nombreElementos.contains(nombreElemento), "La lista no contiene el elmento buscado");
    }
}
