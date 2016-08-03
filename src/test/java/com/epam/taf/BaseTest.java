package com.epam.taf;

import com.epam.taf.properties.PropertyProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected final String URL = "https://accounts.google.com/";
    protected WebDriver driver;

    protected final String LOGIN1 = PropertyProvider.getProperty("accounts", "user1Login");
    protected final String LOGIN2 = PropertyProvider.getProperty("accounts", "user2Login");
    protected final String LOGIN3 = PropertyProvider.getProperty("accounts", "user3Login");
    protected final String PASSWORD = PropertyProvider.getProperty("accounts", "password");

    @BeforeClass
    public void setUp()
    {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
        driver = null;
    }

}
