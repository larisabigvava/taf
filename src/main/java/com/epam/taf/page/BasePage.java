package com.epam.taf.page;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    private LoginPage loginPage;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
}
