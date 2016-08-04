package com.epam.taf.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends BasePage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//div/a[contains(text(), 'Forwarding and POP/IMAP']")
    private WebElement forwarding;

    @FindBy(xpath = "//div/a[contains(text(), 'Themes']")
    private WebElement theme;

    @FindBy(xpath = "//a[contains(text(),'General']")
    private WebElement general;

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public ThemePage goToThemes(){
        theme.click();
        return new ThemePage(this.driver);
    }

    public ForwardingPage goToForwarding(){
        forwarding.click();
        return new ForwardingPage(this.driver);
    }

    public GeneralSettingsPage goToGeneralSettings(){
        general.click();
        return new GeneralSettingsPage(this.driver);
    }


}
