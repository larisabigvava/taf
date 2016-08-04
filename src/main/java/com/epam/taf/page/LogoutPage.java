package com.epam.taf.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BasePage{
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//span[@class='gb_3a gbii']")
    private WebElement accountIcon;

    @FindBy(xpath = "//a[contains(text(), 'Sign out']")
    private WebElement btnLogout;

    @FindBy(xpath = "//a[@id='account-chooser-link']")
    private WebElement btnSignInWithADiffAcc;

    @FindBy(xpath = "//a[@id='account-chooser-add-account']")
    private WebElement btnAddAccount;

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    private void clickSignInWithADifferentAcc(){
        btnSignInWithADiffAcc.click();
    }

    private void clickAddAccount(){
        btnAddAccount.click();
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
        accountIcon.click();
    }

    private void clickLogout(){
        btnLogout.click();
    }
}
