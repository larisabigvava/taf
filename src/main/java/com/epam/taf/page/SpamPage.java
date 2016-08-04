package com.epam.taf.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpamPage extends BasePage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//div/span/a[contains(text(),'Spam (')]")
    private WebElement fullSpam;

    public SpamPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSpamHasLetter(){
        boolean result = false;
        if (fullSpam.isDisplayed()){
            result = true;
        }
        LOGGER.info("checking spam");
        return result;
    }


}
