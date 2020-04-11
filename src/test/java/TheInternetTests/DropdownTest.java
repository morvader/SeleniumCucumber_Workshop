package TheInternetTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class DropdownTest extends BaseTestTestTheInternet {

    @Test
    void checkOptions() {
        final List<String> options = mainPage.goToDropDownPage().getOptions();

        assertEquals(2, options.size(), "El número de opciones no es correcto");
    }

    @Test
    void selectFristOption() {
        String expected = "Option 1";

        String selected = mainPage.goToDropDownPage()
                .selectOption(1)
                .getSelectedOption();

        assertEquals(expected, selected, "Opcion Incorrecta");
    }

    @DataProvider(name = "options")
    public Object[][] createData1() {
        return new Object[][]{
                {"1", "Option 1"},
                {"2", "Option 2"},
        };
    }


    @Test(dataProvider = "options")
    public void testAllOptions(String index, String texto) {
        String expected = texto;

        String selected = mainPage.goToDropDownPage()
                .selectOption(Integer.parseInt(index))
                .getSelectedOption();

        assertEquals(expected, selected, "Opcion Incorrecta");
    }
}
