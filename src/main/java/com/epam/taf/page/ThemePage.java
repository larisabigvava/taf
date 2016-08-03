package com.epam.taf.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThemePage extends LogoutClass {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private WebDriver driver;

    @FindBy(xpath = "//div/a[contains(text(), 'Set Theme.')]")
    private WebElement a_set_theme;

    @FindBy(xpath = "//div[@bgid='custom-10']")
    private WebElement beach_pic;

    @FindBy(xpath = "//div[contains(text(), 'Save')]")
    private WebElement save_btn;

    public ThemePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void setTheme(){
        a_set_theme.click();
        beach_pic.click();
        save_btn.click();
        LOGGER.info("set theme");
    }
}
