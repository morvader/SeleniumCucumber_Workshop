package FormyTests;

import org.testng.annotations.Test;
import pages.formy.DropDownButtonPage;

import static org.testng.Assert.assertTrue;


public class DropDownButtonTest extends BaseTestFormyTest {

    @Test
    public void clickOnElementTest() {
        DropDownButtonPage page = new DropDownButtonPage(driver);
        page.navigateTo();

        String elementName = "Modal";

        page.clickOnElement(elementName);

        assertTrue(driver.getCurrentUrl().endsWith("modal"), "No estamos en la pagina correcta");
    }
}
