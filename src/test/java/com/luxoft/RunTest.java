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

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/com/luxoft/features",
    glue = "com.luxoft.steps",
    dryRun = false,
    monochrome = false,
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    tags = "@web",
    plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty",
            "json:target/cucumber1.json"
    }
)
public class RunTest {

    @BeforeClass
    public static void startDriver(){
        if(Auxillary.driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            options.setHeadless(false);
            Auxillary.driver = new ChromeDriver(options);
            Auxillary.driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            Auxillary.driver.manage().window().maximize();
            Auxillary.driver.navigate().to("https://www.luxoft.com/");
        }
    }

    @AfterClass
    public static void tearDown(){
        Auxillary.driver.quit();
    }
}
