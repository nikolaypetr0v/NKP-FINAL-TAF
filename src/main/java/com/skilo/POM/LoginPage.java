package com.skilo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Iskilo{

    //const
    public static final String LOGIN_PAGE_URL = "http://training.skillo-bg.com:4300/users/login";

    //WebElements or other  UI Map
    @FindBy (css = "p.h4")
    private WebElement loginPageHeaderTitle;
    @FindBy (id = "defaultLoginFormUsername")
    private WebElement usernameInputField;
    @FindBy (id = "defaultLoginFormPassword")
    private WebElement passwordInputField;
    @FindBy (xpath = "//span[contains(text(),'Remember me')]")
    private WebElement rememberMeLabelText;
    @FindBy (xpath = "//input[contains(@formcontrolname,'rememberMe')]")
    private WebElement rememberMeCheckBox;
    @FindBy (css = "#sign-in-button")
    private WebElement loginFormSubmitButton;
    @FindBy (xpath = "//a[contains(.,'Register')]")
    private WebElement loginFormRegistrationLink;

    //Create a constructor
    public LoginPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //User Actions
    public void  provideUserName(String userName) {
       waitAndTypeTextInField(usernameInputField,userName);
    }

    public void providePassword(String userPassword){
        waitAndTypeTextInField(passwordInputField,userPassword);
    }

    public void clickOnLoginSubmitButton(){
        waitAndClickOnWebElement(loginFormSubmitButton);
    }


}
