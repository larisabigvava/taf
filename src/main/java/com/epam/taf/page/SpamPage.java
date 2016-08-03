package com.epam.taf.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Seagull on 03.08.2016.
 */
public class SpamPage extends LogoutClass {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private WebDriver driver;

    /**
     * Rename variable a_spam_full into smth like fullSpam
     */

    @FindBy(xpath = "//div/span/a[contains(text(),'Spam (']")
    private WebElement a_spam_full;

    public SpamPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean isSpamHasLetter(){
        boolean result = false;
        if (a_spam_full.isDisplayed()){
            result = true;
        }
        LOGGER.info("checking spam");
        return result;
    }


}
