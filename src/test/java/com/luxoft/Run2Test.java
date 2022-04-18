package com.luxoft;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.luxoft.Hooks.auxillary;
import static com.luxoft.Hooks.createDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/com/luxoft/features/unit",
    glue = "com.luxoft.steps",
    dryRun = false,
    monochrome = false,
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty",
            "json:target/cucumber3.json"
    }
)
public class Run2Test {


}
