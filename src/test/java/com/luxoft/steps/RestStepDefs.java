package com.luxoft.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luxoft.PostModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class RestStepDefs {
    private RequestSpecification specification;
    private Response response;


    @Given("I use {string} service")
    public void iUseHttpsJsonplaceholderTypicodeComService(String arg0) {
        specification = given().baseUri(arg0);
    }

    @When("I invoke get method at {string}")
    public void iInvokeGetMethodAtPosts(String arg0) throws IOException {
         response = given().spec(specification)
            .when().get(arg0);
    }

    @Then("status code is {int}")
    public void statusCodeIs(int arg0) {
        System.out.println(response.asString());
        response.then().statusCode(arg0);
    }

    @Then("status code is {int} at")
    public void statusCodeIsAt(int arg0, List<String> endpoints) {
        endpoints.forEach(e ->
                given().spec(specification)
                .when().get(e)
                .then().statusCode(arg0)
        );
    }

    @When("I invoke get method at {string} with id {string}")
    public void iInvokeGetMethodAtUsersWithId(String aa, String bb) throws IOException {
        response = given().spec(specification).log().all()
                .pathParam("a", aa)
                .pathParam("b", bb)
                .when().get("/{a}/{b}");
        ObjectMapper mapper = new ObjectMapper();
        PostModel model = mapper.readValue(response.asString(), PostModel.class);
        System.out.println("111");
    }

    @Then("street is {string}")
    public void streetIsKulasLight(String arg0) {
        response.body().prettyPrint();
        response.then().body("address.street", equalTo(arg0));
        response.then().body("email", equalTo("Sincere@april.biz"));
    }
}
