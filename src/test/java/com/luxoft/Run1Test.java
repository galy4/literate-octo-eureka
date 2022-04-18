package com.luxoft;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static com.luxoft.Hooks.auxillary;
import static com.luxoft.Hooks.createDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
//    features = "src/test/java/com/luxoft/features/unit",
    features = "src/test/java/com/luxoft/features/web",
    glue = "com.luxoft.steps",
    dryRun = false,
    monochrome = false,
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    tags = "@webweb",
    plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty",
            "json:target/cucumber2.json"
    }
)
public class Run1Test {

    @BeforeClass
    public static void startDriver(){
        createDriver();
    }

    @AfterClass
    public static void tearDown(){
        auxillary.getDriver().get().quit();
    }
}
