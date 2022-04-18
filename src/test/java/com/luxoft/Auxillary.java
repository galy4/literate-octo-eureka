package com.luxoft;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

@Getter @Setter
public class Auxillary {

    //one thread mode
//    public static WebDriver driver;

    //multythread mode
    public ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(()->null);
    ThreadLocal<Integer> int1 = ThreadLocal.withInitial(()->100);

}
