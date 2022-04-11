package com.luxoft;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {

    @Before(order = 15, value = "@shout and not @positive")
    public void beforeHook(){
        System.out.println("before");
    }

    @Before("@feature2")
    public void beforeHook1(){
        System.out.println("1111111111111111111");
    }

    @After(order = 20)
    public void afterHook(){
        System.out.println("after hook");
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
