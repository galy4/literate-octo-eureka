package com.luxoft;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assumptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class StepDefinitions {
    private int distance;
    boolean hunger = false;

    @Given("Lucy is in {int} m from Sean")
    public void lucy_is_in_m_from_sean(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        distance = int1;
        System.out.println("distance is " + distance);
    }

    @When("Sean shouts {string}")
    public void seanShoutsFreeBagels(String arg0) {
        System.out.println(arg0);
    }

    @Then("Lucy hears Sean message")
    public void lucyHearsSeanMessage() {
        Assumptions.assumingThat(hunger, ()->assertThat(distance, lessThan(15)));
    }

    @Then("Lucy not hear Sean message")
    public void lucyNotHearSeanMessage() {
        assertThat(distance, greaterThan(15));
    }

    @And("Lucy is hungry")
    public void lucyIsHungry() {
        hunger = true;
    }
}
