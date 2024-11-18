package part3_4.com.demoqa.tests.part3.widgets;

import org.testng.annotations.Test;
import part3_4.com.demoqa.base.BaseTest;

public class SelectDropDownTest extends BaseTest {

    @Test
    public void testMultiSelectDropDown() {
       var selectMenuPage =  homePage.goToWidgets().clickSelectMenu();
       selectMenuPage.selectStandardMulti("Volvo");
       selectMenuPage.selectStandardMulti(1);
       selectMenuPage.selectStandardMulti("Audi");
       selectMenuPage.selectStandardMulti(2);

       selectMenuPage.selectStandardMulti("saab");
    }
}
