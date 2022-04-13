package com.luxoft;

import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before(order = 2, value = "@web")
    public void strtDriver(){
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
