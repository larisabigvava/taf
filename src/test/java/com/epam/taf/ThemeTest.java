package com.epam.taf;

import com.epam.taf.page.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ThemeTest extends BaseTest{
    private LoginPage loginPage;

    @BeforeClass
    public void before() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void themeTst(){
        driver.get(URL);
        loginPage.login(LOGIN1,PASSWORD);
        loginPage.goToInbox().goToSettingsPage().goToThemes().setTheme();
        //TODO asserts
    }

}
