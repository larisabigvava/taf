package com.epam.taf.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForwardingPage extends BasePage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//input[@value='Add a forwarding address']")
    private WebElement addForwarding;

    @FindBy(xpath = "//div/div/input[@type='text']")
    private WebElement inputAddress;

    @FindBy(xpath = "//button[@name='next']")
    private WebElement nextBtn;

    public ForwardingPage(WebDriver driver) {
        super(driver);
    }

    public void addForwardingAddress(String address){
        addForwarding.click();
        inputAddress.sendKeys(address);
        nextBtn.click();
        LOGGER.info("add as forwarding address "+address);
    }
}
