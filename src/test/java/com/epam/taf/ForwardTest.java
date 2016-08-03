package com.epam.taf;

import com.epam.taf.page.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForwardTest extends BaseTest{
    private LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        loginPage = new LoginPage(driver);
    }

    @Test
    public void forwardTst(){
        driver.get(URL);
        loginPage.login(LOGIN2, PASSWORD);
        loginPage.goToInbox().goToSettingsPage().goToForwarding().addForwardingAddress(LOGIN3);
        loginPage.logout();
        loginPage.login(LOGIN3, PASSWORD);
        //TODO confirmation and asserts
    }
}
