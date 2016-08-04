package com.epam.taf.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Seagull on 04.08.2016.
 */
public class GeneralSettingsPage extends BasePage{

    @FindBy(xpath = "//div[@aria-label='Signature']")
    private WebElement signature;

    @FindBy(xpath = "//button[@guidedhelpid='save_changes_button'")
    private WebElement saveBtn;

    public GeneralSettingsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public InboxPage setSignature(String sign){
        signature.click();
        signature.sendKeys(sign);
        saveBtn.click();
        return new InboxPage(driver);
    }
}
