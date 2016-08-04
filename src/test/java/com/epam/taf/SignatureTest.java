package com.epam.taf;

import com.epam.taf.businessobject.Message;
import com.epam.taf.businessobject.User;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignatureTest extends BaseTest {

    @BeforeTest
    public void setUp(){
        user1 = new User(LOGIN1,PASSWORD);
    }
    @Test
    public void changingSignatureTest(){
        page.getLoginPage().login(user1);
        page.getLoginPage().goToInbox().goToSettingsPage().goToGeneralSettings().setSignature("Signature");
        Assert.assertTrue(page.getLoginPage().goToInbox().isSignatureSet(LOGIN2,"Message"));
    }
}
