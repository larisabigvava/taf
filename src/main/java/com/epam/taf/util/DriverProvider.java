package com.epam.taf.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverProvider {
    public static WebDriver driver = null;

    public static WebDriver getDriver(String driverType){
        if (driver == null){
            switch (driverType){
                case "ChromeDriver":
                    driver = new ChromeDriver();
                    break;
                case "FirefoxDriver":
                    driver = new FirefoxDriver();
                    break;
                default:
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