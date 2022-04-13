package com.luxoft.steps;

import com.luxoft.Auxillary;
import com.luxoft.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class WebStepDefs {
    private HomePage homePage = new HomePage(Auxillary.driver);

    @Given("home page is opened")
    public void home_page_is_opened() {
        homePage.isElementDisplayed("logo");
    }

    @Then("main menu contain")
    public void main_menu_contain(List<String> items) {
        Assertions.assertTrue(homePage.verifyMenuItems(items));
    }
}
