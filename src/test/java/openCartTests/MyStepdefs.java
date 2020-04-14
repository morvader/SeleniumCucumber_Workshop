package openCartTests;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.openCart.MainPage;
import pages.openCart.ResultsPage;

import java.io.IOException;

import static Base.BaseTest.takeScreenshot;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class MyStepdefs {

    private WebDriver driver;

    private World world;

    MainPage mainPage;
    ResultsPage resultsPage;

    public MyStepdefs(World world) {
        this.world = world;
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        driver = new ChromeDriver();

        world.driver = driver;

        mainPage = new MainPage(driver);
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed())
            takeScreenshot(driver, "./screenshots", scenario.getName());
        driver.quit();
    }

    @Given("^Estoy en la pagina principal$")
    public void estoyEnLaPaginaPrincipal() {
        mainPage.navigateTo();
    }

    @When("^busco el elemento \"([^\"]*)\"$")
    public void buscoElElemento(String item) throws Throwable {
        resultsPage = mainPage.searchItem(item);
        world.selectedItemName = item;
    }

    @Then("^el elemento \"([^\"]*)\" aparece en los resultados con el precio \"([^\"]*)\"$")
    public void elElementoApareceEnLosResultadosConElPrecio(String nombreEsperado, String precioEsperado) throws Throwable {
        final String elementName = resultsPage.getElementName(0);
        final String elementPrice = resultsPage.getElementPrice(0);

        assertEquals(elementName, nombreEsperado, "El nombre del elemento no coincide");
        assertTrue(elementPrice.startsWith(precioEsperado), "El precio del elemeno no coincide");
    }


}
