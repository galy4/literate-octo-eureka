package com.luxoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(String name){
        WebElement elem = null;
        switch(name){
            case "logo":
                elem = driver.findElement(By.className("logo")); break;
        }
        return elem;
    }



    public boolean isElementDisplayed(String name){
        return getElement(name).isDisplayed();
    }

    public boolean verifyMenuItems(List<String> items){
        List<WebElement> menuItems = driver.findElements(By.xpath("//*[@class='header__menu']/ul/li/a"));
        for(WebElement we:menuItems){
            if(!items.contains(we.getText()))
                return false;
        }
        return true;
    }
}
