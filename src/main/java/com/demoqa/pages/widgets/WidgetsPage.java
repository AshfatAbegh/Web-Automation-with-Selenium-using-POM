package com.demoqa.pages.widgets;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class WidgetsPage extends HomePage {

    private By selectMenuItem =By.xpath("//div[@class='element-list collapse show']//li[@id='item-8']");
    private By datePickerMenuItem = By.xpath("//div[@class='element-list collapse show']//li[@id='item-2']");

    public SelectMenuPage clickSelectMenu(){
       scrollToElementJS(selectMenuItem);
       click(selectMenuItem);
       return new SelectMenuPage();
    }

    public DatePickerMenuPage clickDatePicker(){
        scrollToElementJS(datePickerMenuItem);
        click(datePickerMenuItem);
        return new DatePickerMenuPage();
    }
}
