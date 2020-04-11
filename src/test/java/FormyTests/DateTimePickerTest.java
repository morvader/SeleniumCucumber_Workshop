package FormyTests;

import org.testng.annotations.Test;
import pages.formy.DateTimePickerPage;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;

public class DateTimePickerTest extends BaseTestFormyTest {

    @Test
    public void setDateTest() throws ParseException {
        DateTimePickerPage page = new DateTimePickerPage(driver);
        page.navigateTo();

        final String date = "01/01/2020";

        page.setDateInput(date);

        LocalDate selected = page.getDate();

        assertEquals(date, selected.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")), "la fecha no es correcta");
    }

    @Test
    public void setDateClickTest() throws ParseException {
        DateTimePickerPage page = new DateTimePickerPage(driver);
        page.navigateTo();

        int diaMes = 15;

        page.setDateClick(diaMes);

        LocalDate selected = page.getDate();

        assertEquals(selected.getDayOfMonth(), diaMes, "la fecha no es correcta");
    }
}
