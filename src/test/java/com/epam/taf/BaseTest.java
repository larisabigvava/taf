package com.epam.taf;

import com.epam.taf.page.*;
import com.epam.taf.util.DriverProvider;
import com.epam.taf.util.PropertyProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    protected final String URL = PropertyProvider.getProperty("accounts","url");
    protected final String LOGIN1 = PropertyProvider.getProperty("accounts", "user1Login");
    protected final String LOGIN2 = PropertyProvider.getProperty("accounts", "user2Login");
    protected final String LOGIN3 = PropertyProvider.getProperty("accounts", "user3Login");
    protected final String PASSWORD = PropertyProvider.getProperty("accounts", "password");
    protected BasePage page;
    protected LoginPage loginPage;
    protected LogoutPage logoutPage;

    @BeforeClass
    public void setUp() {
        driver = DriverProvider.getDriver(System.getProperty("browser"));
        page = new BasePage(driver);
        loginPage = page.getLoginPage();
        logoutPage = new LogoutPage(driver);
    }

    @AfterClass
    public void tearDown() {
        DriverProvider.closeDriver();
    }

}
