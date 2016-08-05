package com.epam.taf;

import com.epam.taf.businessobject.User;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ForwardTest extends BaseTest{

    @BeforeTest
    public void setUp(){
        user3 = new User(LOGIN3,PASSWORD);
        user2 = new User(LOGIN2,PASSWORD);
    }

    @Test
    public void forwardTst(){
        driver.get(URL);
        page.getLoginPage().login(user2);
        page.getLoginPage().goToInbox().goToSettingsPage().goToForwarding().addForwardingAddress(LOGIN3);
        logoutPage.logout();
        page.getLoginPage().login(user3);
        //TODO confirmation and asserts
        page.getLoginPage().login(user2);
        Assert.assertTrue(page.getLoginPage().goToInbox().isConfirmationLetterReceived());
    }
}
