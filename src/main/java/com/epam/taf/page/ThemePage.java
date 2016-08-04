package com.epam.taf.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThemePage extends BasePage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//div/a[text()='Set Theme.']")
    private WebElement setTheme;

    @FindBy(xpath = "//div[@bgid='custom-10' and @aria-label='By: Romain Guy']")
    private WebElement beachPicFirstLocation;

    @FindBy(xpath = "//div[@bgid='custom-0' and @aria-label='By: Romain Guy']")
    private WebElement beachPicSecondLocation;

    @FindBy(xpath = "//div[text()='Save']")
    private WebElement saveBtn;

    public ThemePage(WebDriver driver) {
        super(driver);
    }

    public void setTheme() {
        setTheme.click();
        beachPicFirstLocation.click();
        saveBtn.click();
        LOGGER.info("set theme");
    }

    public boolean isThemeSet() {
        boolean result = false;
        if (beachPicSecondLocation.isEnabled()) {
            result = true;
        }
        return result;
    }
}
