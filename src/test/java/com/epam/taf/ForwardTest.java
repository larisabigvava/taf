package com.epam.taf;

import com.epam.taf.page.BasePage;
import org.testng.annotations.BeforeClass;
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
    }
}
