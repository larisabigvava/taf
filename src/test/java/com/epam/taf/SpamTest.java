package com.epam.taf;

import com.epam.taf.businessobject.Message;
import com.epam.taf.businessobject.User;
import org.testng.Assert;
import org.testng.annotations.*;

public class SpamTest extends BaseTest {

    @BeforeTest
    public void setUp(){
        user1 = new User(LOGIN1,PASSWORD);
        user2 = new User(LOGIN2,PASSWORD);
        message = new Message();
        message.setRecipient(LOGIN2);
        message.setText("spam letter from user1 to user2");
    }

    @Test
    public void spamTst() {
        driver.get(URL);
        page.getLoginPage().login(user1);
        page.getLoginPage().goToInbox().sendMessage(message);
        logoutPage.logout();
        page.getLoginPage().login(user2);
        page.getLoginPage().goToInbox().markAsSpam();
        logoutPage.logout();
        page.getLoginPage().login(user1);
        page.getLoginPage().goToInbox().sendMessage(message);
        logoutPage.logout();
        page.getLoginPage().login(user2);
        Assert.assertTrue(page.getLoginPage().goToInbox().goToSpamPage().isSpamHasLetter());
    }
}
