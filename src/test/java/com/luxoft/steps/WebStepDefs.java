package com.luxoft.steps;

import com.luxoft.Auxillary;
import com.luxoft.pages.CommonPage;
import com.luxoft.pages.HomePage;
import com.luxoft.pages.PageAlias;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static com.luxoft.Hooks.auxillary;
import static com.luxoft.pages.PageAlias.HOME;

public class WebStepDefs {
    private HomePage homePage = new HomePage(auxillary.getDriver().get());

    private Map<PageAlias, Supplier<? extends CommonPage>> pages = new HashMap<>() {{
        put(HOME, ()->new HomePage(auxillary.getDriver().get()));
    }};

    @Given("{string} page is opened")
    public void home_page_is_opened(String arg0) {
//        homePage.isElementDisplayed("logo");
        pages.get(PageAlias.byDescription(arg0.toLowerCase())).get().isElementDisplayed("logo");
    }

    @Then("main menu contain")
    public void main_menu_contain(List<String> items) {
       Assertions.assertTrue(homePage.verifyMenuItems(items));
    }
}
