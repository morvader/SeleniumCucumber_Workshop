package TheInternetTests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class OpenNewPageTest extends BaseTestTestTheInternet {

    @Test
    public void testOpenNewPage() {
        final String text = mainPage.goToHandleWindowsPage()
                .openNewPage()
                .getText();

        assertEquals(text, "New Window", "El texto no coincide");
    }
}
