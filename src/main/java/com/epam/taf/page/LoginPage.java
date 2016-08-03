package com.epam.taf.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage extends BasePage{
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@id='Email']")
    private WebElement inputLogin;

    @FindBy(xpath = "//*[@id='Passwd']")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id='next']")
    private WebElement btnNextLogin;

    @FindBy(xpath = "//*[@id='signIn']")
    private WebElement btnSignIn;

    @FindBy(xpath = "//a[@title='Google apps']")
    private WebElement googleApps;

    @FindBy(xpath = "//*[@id='gb23']/span[1]")
    private WebElement gmailApp;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void login(String login, String password){
        setLogin(login);
        submitLogin();
        setPassword(password);
        submitPassword();
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOf(googleApps));
        goToInbox();
        LOGGER.info("login as "+login);
    }

    private void setLogin(String login){
        inputLogin.sendKeys(login);
    }

    private void setPassword(String password){
        inputPassword.sendKeys(password);
    }

    private void submitLogin(){
        btnNextLogin.click();
    }

    private void submitPassword(){
        btnSignIn.click();
    }

    public InboxPage goToInbox(){
        googleApps.click();
        gmailApp.click();
        return new InboxPage(this.driver);
    }

}
