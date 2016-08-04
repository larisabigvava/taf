package com.epam.taf.page;

import com.epam.taf.businessobject.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@id='Passwd']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@id='next']")
    private WebElement btnNextLogin;

    @FindBy(xpath = "//*[@id='signIn']")
    private WebElement btnSignIn;

    @FindBy(xpath = "//a[@title='Google apps']")
    private WebElement googleApps;

    @FindBy(xpath = "//a/span[text()='Gmail']")
    private WebElement gmailApp;

    @FindBy(xpath = "//label[@class='remember']/input[@id='PersistentCookie']")
    private WebElement rememberInput;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(User user){
        setLogin(user.getLogin());
        submitLogin();
        setPassword(user.getPassword());
        setNotRemember();
        submitPassword();
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOf(googleApps));
        goToInbox();
        LOGGER.info("login as "+user.getLogin());
    }

    private void setNotRemember(){
        rememberInput.click();
    }

    private void setLogin(String login){
        inputLogin.sendKeys(login);
    }

    private void setPassword(String password){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(inputPassword));
        inputPassword.sendKeys(password);
    }

    private void submitLogin(){
        btnNextLogin.click();
    }

    private void submitPassword(){
        btnSignIn.click();
    }

    public InboxPage goToInbox(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(googleApps));
        googleApps.click();
        gmailApp.click();
        return new InboxPage(this.driver);
    }

}
