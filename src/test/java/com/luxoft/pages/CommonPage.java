package com.luxoft.pages;

import org.openqa.selenium.WebElement;

public abstract class CommonPage implements Page{

    @Override
    public abstract WebElement getElement(String name);

    public boolean isElementDisplayed(String name){
        return getElement(name).isDisplayed();
    }
}
