package com.luxoft.steps;

import com.luxoft.Calculator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

public class MeStepDefs {
    private final Calculator calculator = new Calculator();

    @Given("print some numbers")
    @Step("print some numbers")
    public void printSomeNumbers(List<Float> list) {
        list.forEach(System.out::println);
    }


    @Then("y divides x")
    @Step("y divides x")
    public void yDividesX(List<List<Integer>> list) {
        list.forEach(
                row -> Assertions.assertTrue(calculator.isDivided(row.get(0), row.get(1)))
        );
    }

    @Then("y divides x map")
    @Step("y divides x map")
    public void yDividesXMap(Map<Integer, Integer> map) {
        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
            Assertions.assertTrue(calculator.isDivided(entry.getKey(), entry.getValue()));
        }
    }

    @Then("y divides x title")
    @Step("y divides x title")
    public void yDividesXString(List<List<String>> list) {
        for(int i=1; i<list.size(); i++){
            Assertions.assertTrue(calculator.isDivided(
                    Integer.parseInt(list.get(i).get(0)), Integer.parseInt(list.get(i).get(0)))
            );
        }
    }


    @Then("y divides x table")
    @Step("y divides x table")
    public void yDividesXTable(DataTable dataTable) {
        for(int i=1; i<dataTable.height(); i++){
            Assertions.assertTrue(calculator.isDivided(
                    Integer.parseInt(dataTable.cell(i, 0)),
                    Integer.parseInt(dataTable.cell(i, 1))
            ));
        }
    }
}
