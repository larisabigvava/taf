package com.epam.taf;

import com.epam.taf.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ThemeTest extends BaseTest{

    @Test
    public void changeUserThemeTst(){
        driver.get(URL);
        page.getLoginPage().login(LOGIN1,PASSWORD);
        page.getLoginPage().goToInbox().goToSettingsPage().goToThemes().setTheme();
        Assert.assertTrue(page.getLoginPage().goToInbox().goToSettingsPage().goToThemes().isThemeSet());
    }

}
