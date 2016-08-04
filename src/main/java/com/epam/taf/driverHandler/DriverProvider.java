package com.epam.taf.driverHandler;

import com.epam.taf.util.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverProvider {
    public static WebDriver driver = null;

    public static WebDriver getDriver(String driverType){
        if (driver == null){
            DriverType type;
            try {
                type = DriverType.valueOf(driverType);
            }
            catch(IllegalArgumentException|NullPointerException e){
                type = DriverType.FirefoxDriver;
            }
            switch (type){
                case ChromeDriver:
                    driver = new ChromeDriver();
                    break;
                case FirefoxDriver:
                    driver = new FirefoxDriver();
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
