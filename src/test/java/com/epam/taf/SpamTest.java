package com.epam.taf;

import com.epam.taf.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class SpamTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeClass
    public void before() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void spamTst() {
        driver.get(URL);
        loginPage.login(LOGIN1, PASSWORD);
        loginPage.goToInbox().sendMessage(LOGIN2, "spam letter from user1 to user2");
        loginPage.logout();
        loginPage.login(LOGIN2, PASSWORD);
        loginPage.goToInbox().markAsSpam();
        loginPage.logout();
        loginPage.login(LOGIN1, PASSWORD);
        loginPage.goToInbox().sendMessage(LOGIN2, "new spam letter from user1 to user2");
        loginPage.logout();
        loginPage.login(LOGIN2, PASSWORD);
        Assert.assertTrue(loginPage.goToInbox().goToSpamPage().isSpamHasLetter());
    }
}
