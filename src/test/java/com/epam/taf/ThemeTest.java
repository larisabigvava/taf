package com.epam.taf;

import com.epam.taf.page.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ThemeTest extends BaseTest{

    @Test
    public void themeTst(){
        driver.get(URL);
        page.getLoginPage().login(LOGIN1,PASSWORD);
        page.getLoginPage().goToInbox().goToSettingsPage().goToThemes().setTheme();
        //TODO asserts
    }

}
