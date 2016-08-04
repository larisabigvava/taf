package com.epam.taf.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralSettingsPage extends BasePage{

    @FindBy(xpath = "//div[@aria-label='Signature']")
    private WebElement signature;

    @FindBy(xpath = "//button[@guidedhelpid='save_changes_button'")
    private WebElement saveBtn;

    public GeneralSettingsPage(WebDriver driver) {
        super(driver);
    }

    public InboxPage setSignature(String sign){
        signature.click();
        signature.sendKeys(sign);
        saveBtn.click();
        return new InboxPage(driver);
    }
}
