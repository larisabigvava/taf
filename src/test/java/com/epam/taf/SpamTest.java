package com.epam.taf;

import org.testng.Assert;
import org.testng.annotations.*;

public class SpamTest extends BaseTest {

    @Test
    public void spamTst() {
        driver.get(URL);
        page.getLoginPage().login(LOGIN1, PASSWORD);
        page.getLoginPage().goToInbox().sendMessage(LOGIN2, "spam letter from user1 to user2");
        logoutPage.logout();
        page.getLoginPage().login(LOGIN2, PASSWORD);
        page.getLoginPage().goToInbox().markAsSpam();
        logoutPage.logout();
        page.getLoginPage().login(LOGIN1, PASSWORD);
        page.getLoginPage().goToInbox().sendMessage(LOGIN2, "new spam letter from user1 to user2");
        logoutPage.logout();
        page.getLoginPage().login(LOGIN2, PASSWORD);
        Assert.assertTrue(page.getLoginPage().goToInbox().goToSpamPage().isSpamHasLetter());
    }
}
