package TheInternetTests;

import org.testng.annotations.Test;
import pages.theinternet.HoversPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTest extends BaseTestTestTheInternet {

    @Test(description = "Comprobar que los datos del usuario 2 son correctos")
    public void testDatosCorrectorUsuario2() {
        final HoversPage hoversPage = mainPage.goToHoverPage();
        int userPosition = 1;
        final String userName = "name: user2";

        hoversPage.hoverUser(userPosition);

        final String actualUserName = hoversPage.getUserName(userPosition);

        assertTrue(hoversPage.isUserCaptionDisplayed(userPosition));
        assertEquals(userName, actualUserName, "El nombre del usuario 2 no es correcto");
    }
}
