package FormyTests;

import org.testng.annotations.Test;
import pages.formy.ScrollingPage;

import static org.testng.Assert.assertEquals;


public class ScrollTest extends BaseTestFormyTest {

    @Test
    public void setDateTest() {
        ScrollingPage page = new ScrollingPage(driver);
        page.navigateTo();

        final String date = "01-01-2020";
        final String name = "Fran";

        page.setName(name);
        page.setDate(date);

        String nombre = page.getName();
        String fecha = page.getDate();

        assertEquals(nombre, name, "El nombre no es correcto");
        assertEquals(date, fecha, "la fecha no es correcta");
    }
}
