package com.epam.taf.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage extends BasePage{
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//div[@role='menu']")
    private WebElement settingsMenuList;

    @FindBy(xpath = "//div[@aria-label='Settings']")
    private WebElement settingsIcon;

    @FindBy(xpath = "//[contains(text(), 'Settings')]")
    private WebElement settings;

    @FindBy(xpath = "//*[contains(text(), 'COMPOSE')]")
    private WebElement btnCompose;

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement toWhom;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement textPath;

    @FindBy(xpath = "//*[contains(text(), 'Send')]")
    private WebElement btnSend;

    @FindBy(xpath = "//span[@role = 'checkbox']/div[@role='presentation']")
    private WebElement letterCheckbox;

    @FindBy(xpath = "//div[@aria-label='Report spam']")
    private WebElement btnSpam;

    @FindBy(xpath = "//a[@title='Inbox ('")
    private WebElement inbox;

    public InboxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    private void checkLetters(){
        letterCheckbox.click();
    }

    private void clickSpam(){
        btnSpam.click();
    }

    public void markAsSpam(){
        checkLetters();
        clickSpam();
        LOGGER.info("mark letter as spam");
    }

    private void clickCompose(){
        btnCompose.click();
    }

    private void setRecipient(String recipient){
        toWhom.sendKeys(recipient);
    }

    private void setText(String text){
        textPath.sendKeys(text);
    }

    private void send(){
        btnSend.click();
    }

    public void sendMessage(String recipient, String text){
        clickCompose();
        setRecipient(recipient);
        setText(text);
        send();
        LOGGER.info("send message to user "+recipient);
    }

    public SettingsPage goToSettingsPage(){
        settingsIcon.click();
        settings.click();
        return new SettingsPage(this.driver);
    }

    public SpamPage goToSpamPage(){
        return new SpamPage(this.driver);
    }

    public boolean isSettingsMenuDropDown(){
        boolean result = false;
        if (settingsMenuList.isDisplayed()){
            result = true;
        }
        return result;
    }

    public boolean isConfirmationLetterReceived(){
        boolean result = false;
        if (inbox.isDisplayed()){
            result = true;
        }
        return result;
    }

    public boolean isSignatureSet(String recipient, String letter){
        boolean result = false;
        clickCompose();
        setRecipient(recipient);
        setText(letter);
        if (textPath.getText().contains("--")){
            result = true;
        }
        return result;
    }


}
