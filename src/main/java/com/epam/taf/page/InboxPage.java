package com.epam.taf.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage extends LogoutClass{
    private static final Logger LOGGER = LogManager.getRootLogger();
    private WebDriver driver;

    @FindBy(xpath = "//div[@aria-label='Settings']")
    private WebElement settings_icon;

    @FindBy(xpath = "//[contains(text(), 'Settings')]")
    private WebElement settings;

    @FindBy(xpath = "//*[contains(text(), 'COMPOSE')]")
    private WebElement btn_compose;

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement to_whom;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement text_path;

    @FindBy(xpath = "//*[contains(text(), 'Send')]")
    private WebElement btn_send;

    @FindBy(xpath = "//span[@role = 'checkbox']/div[@role='presentation']")
    private WebElement letter_checkbox;

    @FindBy(xpath = "//div[@aria-label='Report spam']")
    private WebElement btn_spam;

    public InboxPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    private void checkLetters(){
        letter_checkbox.click();
    }

    private void clickSpam(){
        btn_spam.click();
    }

    public void markAsSpam(){
        checkLetters();
        clickSpam();
        LOGGER.info("mark letter as spam");
    }

    private void clickCompose(){
        btn_compose.click();
    }

    private void setRecipient(String recipient){
        to_whom.sendKeys(recipient);
    }

    private void setText(String text){
        text_path.sendKeys(text);
    }

    private void send(){
        btn_send.click();
    }

    public void sendMessage(String recipient, String text){
        clickCompose();
        setRecipient(recipient);
        setText(text);
        send();
        LOGGER.info("send message to user "+recipient);
    }

    public SettingsPage goToSettingsPage(){
        settings_icon.click();
        settings.click();
        return new SettingsPage(this.driver);
    }

    public SpamPage goToSpamPage(){
        return new SpamPage(this.driver);
    }
}
