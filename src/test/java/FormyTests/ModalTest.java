package FormyTests;

import org.testng.annotations.Test;
import pages.formy.ModalPage;

import static org.testng.Assert.assertEquals;

public class ModalTest extends BaseTestFormyTest {

    @Test
    public void testModal() {
        ModalPage page = new ModalPage(driver);
        page.navigateTo();

        page.openModal();

        final String modalTittle = page.getModalTittle();

        assertEquals(modalTittle, "Modal title", "El titulo no coincide");
    }
}
