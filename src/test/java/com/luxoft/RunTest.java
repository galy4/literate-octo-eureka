package com.luxoft;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/com/luxoft/features",
    glue = "com.luxoft.steps",
    dryRun = false,
    monochrome = false,
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    tags = "@shout",
    plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty"}
)
public class RunTest {
}
