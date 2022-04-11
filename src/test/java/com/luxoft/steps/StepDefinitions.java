package com.luxoft.steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assumptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class StepDefinitions {
    private int distance;
    boolean hunger = false;

    @Given("^.ucy .* (\\d+) m from Sean$")
    public void lucy_is_in_m_from_sean(Integer int1) {
        // Write code here that turns the phrase above into concrete actions

        distance = int1;
        System.out.println("distance is " + distance);
    }

    @When("^Sean \\w+ '([^']*)'$")
    public void seanShoutsFreeBagels1(String arg0) {
        System.out.println(arg0);
    }

    @Then("^Lucy (hears|not hear) Sean message$")
    public void lucyHearsSeanMessage(String arg0) {
        if(arg0.equalsIgnoreCase("hears"))
            Assumptions.assumingThat(hunger, ()->assertThat(distance, lessThan(15)));
        else
            assertThat(distance, greaterThan(15));
    }

    @And("^(?:Lucy|Alice|Kate) is hungry$")
    public void lucyIsHungry() {
        hunger = true;
    }

    @But("Lucy is not hungry")
    public void lucyIsNotHungry() {
        hunger = false;
    }



    @When("Sean shouts")
    public void seanShouts(String arg) {
        System.out.println(arg);
        throw new io.cucumber.java.PendingException();
    }
}
