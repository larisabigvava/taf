package com.epam.taf.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForwardingPage extends LogoutClass {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private WebDriver driver;

    @FindBy(xpath = "//input[@value='Add a forwarding address']")
    private WebElement add_forwarding;

    @FindBy(xpath = "//div/div/input[@type='text']")
    private WebElement input_address;

    @FindBy(xpath = "//button[@name='next']")
    private WebElement next_btn;

    public ForwardingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void addForwardingAddress(String address){
        add_forwarding.click();
        input_address.sendKeys(address);
        next_btn.click();
        LOGGER.info("add as forwarding address "+address);
    }
}
