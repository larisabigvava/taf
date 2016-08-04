package com.epam.taf.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage extends BasePage{
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//a[contains(@title, 'Google Account:')]/span")
    private WebElement accountIcon;

    @FindBy(xpath = "//a[text()='Sign out']")
    private WebElement btnLogout;

    @FindBy(xpath = "//a[@id='account-chooser-link']")
    private WebElement btnSignInWithADiffAcc;

    @FindBy(xpath = "//a[@id='account-chooser-add-account']")
    private WebElement btnAddAccount;

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    private void clickSignInWithADifferentAcc(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(btnSignInWithADiffAcc));
        btnSignInWithADiffAcc.click();
    }

    private void clickAddAccount(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(btnAddAccount));
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
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(btnLogout));
        btnLogout.click();
    }
}
