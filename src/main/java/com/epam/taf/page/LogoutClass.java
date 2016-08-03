package com.epam.taf.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutClass {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private WebDriver driver;

    @FindBy(xpath = "//span[@class='gb_3a gbii']")
    private WebElement account_icon;

    @FindBy(xpath = "//a[contains(text(), 'Sign out']")
    private WebElement btn_logout;

    @FindBy(xpath = "//a[@id='account-chooser-link']")
    private WebElement btn_signInWithADiffAcc;

    @FindBy(xpath = "//a[@id='account-chooser-add-account']")
    private WebElement btn_addAccount;

    public LogoutClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    private void clickSignInWithADifferentAcc(){
        btn_signInWithADiffAcc.click();
    }

    private void clickAddAccount(){
        btn_addAccount.click();
    }

    public LoginPage logout(){
        pressAccountIcon();
        clickLogout();
        clickSignInWithADifferentAcc();
        clickAddAccount();
        LOGGER.info("log out");
        return new LoginPage(this.driver);
    }
    private void pressAccountIcon(){
        account_icon.click();
    }

    private void clickLogout(){
        btn_logout.click();
    }
}
