package com.epam.taf.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends LogoutClass {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private WebDriver driver;

    @FindBy(xpath = "//div/a[contains(text(), 'Forwarding and POP/IMAP']")
    private WebElement forwarding;

    @FindBy(xpath = "//div/a[contains(text(), 'Themes']")
    private WebElement theme;

    public SettingsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public ThemePage goToThemes(){
        theme.click();
        return new ThemePage(this.driver);
    }

    public ForwardingPage goToForwarding(){
        forwarding.click();
        return new ForwardingPage(this.driver);
    }


}
