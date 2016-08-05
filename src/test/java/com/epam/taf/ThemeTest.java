package com.epam.taf;

import com.epam.taf.businessobject.User;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ThemeTest extends BaseTest{

    @BeforeTest
    public void setUp(){
        user1 = new User(LOGIN1,PASSWORD);
    }

    @Test
    public void changeUserThemeTst(){
        driver.get(URL);
        page.getLoginPage().login(user1);
        page.getLoginPage().goToInbox().goToSettingsPage().goToThemes().setTheme();
        Assert.assertTrue(page.getLoginPage().goToInbox().goToSettingsPage().goToThemes().isThemeSet());
    }

}
