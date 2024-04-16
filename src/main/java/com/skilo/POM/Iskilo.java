package com.skilo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Iskilo {

    WebDriver driver;
    WebDriverWait wait;

    public Iskilo(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitAndClickOnWebElement(WebElement elm) {
        //Waiting for the element to be ready for click interaction
        wait.until(ExpectedConditions.visibilityOf(elm));
        wait.until(ExpectedConditions.elementToBeClickable(elm));
        //User interaction with the element
        elm .click();
    }

    public void waitAndTypeTextInField(WebElement textField, String inputText){
        wait.until(ExpectedConditions.visibilityOf(textField));
        textField.clear();
        textField.sendKeys(inputText);
    }
}
