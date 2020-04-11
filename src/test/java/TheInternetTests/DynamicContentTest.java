package TheInternetTests;

import org.testng.annotations.Test;
import pages.theinternet.DynamicControlPage;

import static org.testng.Assert.*;

public class DynamicContentTest extends BaseTestTestTheInternet {
    @Test
    public void testDynamicControls() {

        DynamicControlPage dynamicControlsPage = mainPage.goToDynamicControlPage();

        assertTrue(dynamicControlsPage.isCheckBoxPresent(), "El checkbox no esta presente al inicio");

        dynamicControlsPage.clickButton();

        String mensaje = dynamicControlsPage.getMensaje();
        assertEquals(mensaje, "It's gone!");
        assertFalse(dynamicControlsPage.isCheckBoxPresent(), "El checkbox está presente después de pulsar el botón que lo hace desparacer");


        dynamicControlsPage.clickButton();
        mensaje = dynamicControlsPage.getMensaje();
        assertEquals(mensaje, "It's back!");
        assertTrue(dynamicControlsPage.isCheckBoxPresent(), "El checkbox no está  presente después de pulsar el botón que lo hace aparacer");
    }
}
