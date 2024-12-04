package part3_4.com.demoqa.tests.part3.widgets;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.BaseTest;

public class DateTest extends BaseTest {

    String month = "November";
    String monthNumber = "11";
    String day = "25";
    String year = "2024";

    @Test
    public void testSelectingDate() {
        var datePickerPage = homePage.goToWidgets().clickDatePicker();
        datePickerPage.clickSelectDate();
        datePickerPage.selectMonth(month);
        datePickerPage.selectYear(year);
        datePickerPage.clickDay(day);

        String actualDate = datePickerPage.getDate();
        String expectedDate = monthNumber + "/" + day + "/" + year;
        Assert.assertEquals(actualDate, expectedDate, "\n Actual & Expected date don't match" +
                                                               "\n Actual Date: " + actualDate +
                                                               "\n Expected Date: " + expectedDate);
    }
}
