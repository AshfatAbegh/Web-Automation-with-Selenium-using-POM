package com.demoqa.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utilities.DropDownUtility.*;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class SelectMenuPage extends WidgetsPage{

    private By standardMultiSelect = By.id("cars");

    public void selectStandardMulti(String text){
        scrollToElementJS(standardMultiSelect);
//        Select select = new Select(find(standardMultiSelect));
//        select.selectByVisibleText(text);

        selectByVisibleText(standardMultiSelect, text);
    }

    public void selectStandardMulti(int index){
        scrollToElementJS(standardMultiSelect);
//        Select select = new Select(find(standardMultiSelect));
//        select.selectByVisibleText(text);

        selectByIndex(standardMultiSelect, index);
    }

    public void deselectStandardMulti(String value){
        scrollToElementJS(standardMultiSelect);
//        Select select = new Select(find(standardMultiSelect));
//        select.selectByVisibleText(text);

        deselectByValue(standardMultiSelect, value);
    }

    public List<String> getAllSelectedMultiOptions(){
        return getAllSelectedOptions(standardMultiSelect);
    }
}
