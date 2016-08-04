package com.epam.taf;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ForwardTest extends BaseTest{

    @Test
    public void forwardTst(){
        driver.get(URL);
        page.getLoginPage().login(LOGIN2, PASSWORD);
        page.getLoginPage().goToInbox().goToSettingsPage().goToForwarding().addForwardingAddress(LOGIN3);
        logoutPage.logout();
        page.getLoginPage().login(LOGIN3, PASSWORD);
        //TODO confirmation and asserts
        page.getLoginPage().login(LOGIN2,PASSWORD);
        Assert.assertTrue(page.getLoginPage().goToInbox().isConfirmationLetterReceived());
    }
}
