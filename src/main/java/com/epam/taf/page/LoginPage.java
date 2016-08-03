package com.epam.taf.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage extends LogoutClass {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='Email']")
    private WebElement input_login;

    @FindBy(xpath = "//*[@id='Passwd']")
    private WebElement input_password;

    @FindBy(xpath = "//*[@id='next']")
    private WebElement btn_next_login;

    @FindBy(xpath = "//*[@id='signIn']")
    private WebElement btn_signIn;

    @FindBy(xpath = "//a[@title='Google apps']")
    private WebElement google_apps;

    @FindBy(xpath = "//*[@id='gb23']/span[1]")
    private WebElement gmail_app;


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void login(String login, String password){
        setLogin(login);
        submitLogin();
        setPassword(password);
        submitPassword();
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOf(google_apps));
        goToInbox();
        LOGGER.info("login as "+login);
    }

    private void setLogin(String login){
        input_login.sendKeys(login);
    }

    private void setPassword(String password){
        input_password.sendKeys(password);
    }

    private void submitLogin(){
        btn_next_login.click();
    }

    private void submitPassword(){
        btn_signIn.click();
    }

    public InboxPage goToInbox(){
        google_apps.click();
        gmail_app.click();
        return new InboxPage(this.driver);
    }

}
