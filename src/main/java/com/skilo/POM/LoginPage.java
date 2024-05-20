package com.skilo.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Iskilo {
    //const
    public static final String LOGIN_PAGE_URL = "http://training.skillo-bg.com:4200/users/login";

    //WebElements or other  UI Map
    @FindBy (css = "p.h4.mb-4")
    private WebElement loginPageHeaderTitle;
    @FindBy (id = "defaultLoginFormUsername")
    private WebElement usernameInputField;
    @FindBy (id = "defaultLoginFormPassword")
    private WebElement passwordInputField;
    @FindBy (xpath = "//span[contains(text(),'Remember me')]")
    private WebElement rememberMeLblTxt;
    @FindBy (xpath = "//input[contains(@formcontrolname,'rememberMe')]")
    private WebElement rememberMeCheckbox;
    @FindBy (css = "#sign-in-button")
    private WebElement loginFormSubmitButton;
    @FindBy (xpath = "//a[contains(.,'Register')]")
    private WebElement loginFormRegistrationLink;

    //Create a constructor
    public LoginPage (WebDriver driver, Logger log) {
        super(driver,log);
        PageFactory.initElements(driver,this);
    }

    //User Actions
    public void provideUsername(String username) {
       waitAndTypeTextInField(usernameInputField, username);
    }

    public void providePassword(String userPassword){
        waitAndTypeTextInField(passwordInputField,userPassword);
    }

    public void clickOnRememberMeCheckbox(){
        waitAndClickOnWebElement(rememberMeCheckbox);
    }

    public void clickOnLoginSubmitBtn(){
        waitAndClickOnWebElement(loginFormSubmitButton);
    }

    public void clickOnLoginRegisterLink(){
        waitAndClickOnWebElement(loginFormRegistrationLink);
    }

    public void loginWithUserAndPassword(String username, String password) {
        provideUsername(username);
        providePassword(password);
        clickOnRememberMeCheckbox();
        clickOnLoginSubmitBtn();
    }

    //getters
    public String getUsernamePlaceholder () {
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        return usernameInputField.getAttribute("placeholder");
    }

    public String getPasswordPlaceholder () {
        wait.until(ExpectedConditions.visibilityOf(passwordInputField));
        return passwordInputField.getAttribute("placeholder");
    }

    public String getLoginPageHeader () {
        wait.until(ExpectedConditions.visibilityOf(loginPageHeaderTitle));
        return loginPageHeaderTitle.getText();
    }

    public boolean isUsernamePlaceholderCorrect(String expectedUsernamePlaceholder) {
        boolean isPerRequirments = false;

        try {
             String actualUsernamePlaceholder = getUsernamePlaceholder();
             isPerRequirments = expectedUsernamePlaceholder.equals(actualUsernamePlaceholder);
             if(isPerRequirments){
                 log.error("ERROR ! The username placeholder is correct");
             }
        } catch (NoSuchElementException e){
            log.error("ERROR ! The username placeholder is not correct");
        }
        return isPerRequirments;
    }

    public boolean isPasswordPlaceholderCorrect(String expectedPasswordPlaceholder) {
        boolean isPerRequirments = false;

        try {
            String actualPasswordPlaceholder = getPasswordPlaceholder();
            isPerRequirments = expectedPasswordPlaceholder.equals(actualPasswordPlaceholder);
            if(isPerRequirments){
                log.error("ERROR ! The password placeholder is correct");
            }
        } catch (NoSuchElementException e){
            log.error("ERROR ! The password placeholder is not correct");
        }
        return isPerRequirments;
    }

    public boolean isLoginPageOpenedPerRequirements(String expectedLoginPageHeaderTxt){
        boolean isLoginPagePerRequirements = false;

        try{
            String actualLoginPageHeaderText = getLoginPageHeader();
            isLoginPagePerRequirements = expectedLoginPageHeaderTxt.equals(actualLoginPageHeaderText);
            if (isLoginPagePerRequirements) {
                System.out.println("There is a match! Actual login page header matches the criteria ");
            }
        } catch (NoSuchElementException e){
            log.error("ERROR ! The Login page is not opened per requirements.");
        }
        return isLoginPagePerRequirements;
    }
}
