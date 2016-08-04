package com.epam.taf;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignatureTest extends BaseTest {

    @Test
    public void changingSignatureTest(){
        page.getLoginPage().login(LOGIN1,PASSWORD);
        page.getLoginPage().goToInbox().goToSettingsPage().goToGeneralSettings().setSignature("Signature");
        Assert.assertTrue(page.getLoginPage().goToInbox().isSignatureSet(LOGIN2,"Message"));
    }
}
