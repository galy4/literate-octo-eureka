package com.luxoft;

import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static Auxillary auxillary = new Auxillary();

    @Before(order = 2, value = "@web")
    public void strtDriver(){
        if(auxillary.getDriver().get() == null) {
           createDriver();
        }
    }

    @Before(order = 15, value = "@shout and not @positive")
    public void beforeHook(){
        System.out.println("before");
    }

    @Before("@feature2")
    public void beforeHook1(){
        System.out.println("1111111111111111111");
    }

    @After(order = 20)
    public void afterHook(Scenario scenario){
        System.out.println(scenario.getName());
    }

    @After(order = 30)
    public void afterHook1(){
        System.out.println("22222222222222");
    }

    @After(value = "@web or @webweb")
    public void takeScreenshot(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) auxillary.getDriver().get()).getScreenshotAs(OutputType.BYTES); //take screenshot
            scenario.attach(screenshot, "image/png", scenario.getName()); // ... and embed it in the report.
        }

    }

    public static void createDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.setHeadless(false);
        auxillary.getDriver().set(new ChromeDriver(options));
        auxillary.getDriver().get().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        auxillary.getDriver().get().manage().window().maximize();
        auxillary.getDriver().get().navigate().to("https://www.luxoft.com/");
    }

//    @BeforeStep
//    public void weirdHook(){
//        System.out.println("++++++++++++");
//    }
//
//    @AfterStep
//    public void weirdHook1(){
//        System.out.println("00000000000");
//    }
}
