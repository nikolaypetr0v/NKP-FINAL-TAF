package com.skilo.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends Iskilo {
    public static final String REGISTRATION_PAGE_URL = "http://training.skillo-bg.com:4200/users/register";

    @FindBy (css = "h4.text-center.mb-4")
    private WebElement registrationPageHeaderTitle;
    @FindBy (xpath = "//input[contains(@formcontrolname,'username')]")
    private WebElement usernameTxtInputField;
    @FindBy (xpath = "//input[contains(@formcontrolname,'email')]")
    private WebElement emailTxtInputField;
    @FindBy (xpath = "//input[contains(@formcontrolname,'birthDate')]")
    private WebElement birthDateInputField;
    @FindBy (id = "defaultRegisterFormPassword")
    private WebElement passwordTxtInputField;
    @FindBy (id = "defaultRegisterPhonePassword") // Бъг - тук за id на "Confirm password" текстово поле би трябвало да е "defaultRegisterFormConfirmPassword" вместо сегашното "defaultRegisterPhonePassword"
    private WebElement confirmPasswordTxtInputField;
    @FindBy (xpath = "//textarea[contains(@formcontrolname,'publicInfo')]")
    private WebElement publicInfoTxtInputField;
    @FindBy (id = "sign-in-button") // Бъг - тук за id на Registration page submit бутон би трябвало да е "sign-up-button" вместо сегашното "sign-in-button"
    private WebElement registrationFormSubmitBtn;

    public RegistrationPage (WebDriver driver, Logger log) {
        super(driver,log);
        PageFactory.initElements(driver,this);
    }

    public String getRegistrationPageHeader () {
        wait.until(ExpectedConditions.visibilityOf(registrationPageHeaderTitle));
        return registrationPageHeaderTitle.getText();
    }

    public String getUsernamePlaceholder() {
        wait.until(ExpectedConditions.visibilityOf(usernameTxtInputField));
        return usernameTxtInputField.getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        wait.until(ExpectedConditions.visibilityOf(emailTxtInputField));
        return emailTxtInputField.getAttribute("placeholder");
    }

    public String getBirthDatePlaceholder() {
        wait.until(ExpectedConditions.visibilityOf(birthDateInputField));
        return birthDateInputField.getAttribute("placeholder");
    }

    public String getPasswordPlaceholder() {
        wait.until(ExpectedConditions.visibilityOf(passwordTxtInputField));
        return passwordTxtInputField.getAttribute("placeholder");
    }

    public String getConfirmPasswordPlaceholder() {
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordTxtInputField));
        return confirmPasswordTxtInputField.getAttribute("placeholder");
    }

    public String getPublicInfoPlaceholder() {
        wait.until(ExpectedConditions.visibilityOf(publicInfoTxtInputField));
        return publicInfoTxtInputField.getAttribute("placeholder");
    }

    public String getRegistrationBtnLbl() {
        wait.until(ExpectedConditions.visibilityOf(registrationFormSubmitBtn));
        return registrationFormSubmitBtn.getText();
    }

    public boolean isRegPageHeaderCorrect(String expectedRegistrationPageHeaderTxt){
        boolean isRegPageHeaderValid = false;

        try{
            String actualRegistrationPageHeaderTxt = getRegistrationPageHeader();
            isRegPageHeaderValid = expectedRegistrationPageHeaderTxt.equals(actualRegistrationPageHeaderTxt);
            if (isRegPageHeaderValid) {
                System.out.println("There is a match! Actual registration page header matches the criteria ");
            }
        } catch (NoSuchElementException e){
            log.error("ERROR ! The registration page header is not per requirements.");
        }
        return isRegPageHeaderValid;
    }

    public boolean isRegUsernamePlaceholderCorrect(String expectedUsernamePlaceholder) {
        boolean isRegUsernameCorrect = false;

        try {
            String actualUsernamePlaceholder = getUsernamePlaceholder();
            isRegUsernameCorrect = expectedUsernamePlaceholder.equals(actualUsernamePlaceholder);
            if (isRegUsernameCorrect) {
                System.out.println("There is a match! Actual registration username placeholder matches the criteria ");
            }
        } catch (NoSuchElementException e){
            log.error("ERROR ! The registration username placeholder is not correct");
        }
        return isRegUsernameCorrect;
    }

    public boolean isRegEmailPlaceholderCorrect(String expectedEmailPlaceholder) {
        boolean isRegEmailCorrect = false;

        try {
            String actualEmailPlaceholder = getEmailPlaceholder();
            isRegEmailCorrect = expectedEmailPlaceholder.equals(actualEmailPlaceholder);
            if (isRegEmailCorrect) {
                System.out.println("There is a match! Actual registration email placeholder matches the criteria ");
            }
        } catch (NoSuchElementException e){
            log.error("ERROR ! The registration email placeholder is not correct");
        }
        return isRegEmailCorrect;
    }

    public boolean isRegBirthDatePlaceholderCorrect(String expectedBirthDatePlaceholder) {
        boolean isRegBirthDateCorrect = false;

        try {
            String actualBirthDatePlaceholder = getBirthDatePlaceholder();
            isRegBirthDateCorrect = expectedBirthDatePlaceholder.equals(actualBirthDatePlaceholder);
            if (isRegBirthDateCorrect) {
                System.out.println("There is a match! Actual registration birth date placeholder matches the criteria ");
            }
        } catch (NoSuchElementException e){
            log.error("ERROR ! The registration birth date placeholder is not correct");
        }
        return isRegBirthDateCorrect;
    }

    public boolean isRegPasswordPlaceholderCorrect(String expectedPasswordPlaceholder) {
        boolean isRegPasswordCorrect = false;

        try {
            String actualPasswordPlaceholder = getPasswordPlaceholder();
            isRegPasswordCorrect = expectedPasswordPlaceholder.equals(actualPasswordPlaceholder);
            if (isRegPasswordCorrect) {
                System.out.println("There is a match! Actual registration password placeholder matches the criteria ");
            }
        } catch (NoSuchElementException e){
            log.error("ERROR ! The registration password placeholder is not correct");
            isRegPasswordCorrect = false;
        }
        return isRegPasswordCorrect;
    }

    public boolean isRegConfirmPasswordPlaceholderCorrect(String expectedConfirmPasswordPlaceholder) {
        boolean isRegConfirmPasswordCorrect = false;

        try {
            String actualConfirmPasswordPlaceholder = getConfirmPasswordPlaceholder();
            isRegConfirmPasswordCorrect = expectedConfirmPasswordPlaceholder.equals(actualConfirmPasswordPlaceholder);
            if (isRegConfirmPasswordCorrect) {
                System.out.println("There is a match! Actual registration confirmPassword placeholder matches the criteria ");
            }
        } catch (NoSuchElementException e){
            log.error("ERROR ! The registration confirmPassword placeholder is not correct");
            isRegConfirmPasswordCorrect = false;
        }
        return isRegConfirmPasswordCorrect;
    }

    public boolean isRegPublicInfoPlaceholderCorrect(String expectedPublicInfoPlaceholder) {
        boolean isRegPublicInfoCorrect = false;

        try {
            String actualPublicInfoPlaceholder = getPublicInfoPlaceholder();
            isRegPublicInfoCorrect = expectedPublicInfoPlaceholder.equals(actualPublicInfoPlaceholder);
            if (isRegPublicInfoCorrect) {
                System.out.println("There is a match! Actual registration public info placeholder matches the criteria ");
            }
        } catch (NoSuchElementException e){
            log.error("ERROR ! The registration public info placeholder is not correct");
            isRegPublicInfoCorrect = false;
        }
        return isRegPublicInfoCorrect;
    }

    public boolean isRegBtnLblCorrect(String expectedRegistrationBtnLbl) {
        boolean isRegBtnCorrect = false;

        try {
            String actualRegistrationBtnLbl = getRegistrationBtnLbl();
            isRegBtnCorrect = expectedRegistrationBtnLbl.equals(actualRegistrationBtnLbl);
            if (isRegBtnCorrect) {
                System.out.println("There is a match! Actual registration submit button label matches the criteria ");
            }
        } catch (NoSuchElementException e){
            log.error("ERROR ! The registration submit button label is not correct");
            isRegBtnCorrect = false;
        }
        return isRegBtnCorrect;
    }

    public void provideUsername(String username) {
        waitAndTypeTextInField(usernameTxtInputField, username);
    }

    public void provideEmail(String email) {
        waitAndTypeTextInField(emailTxtInputField, email);
    }

    public void providePassword(String userPassword) {
        waitAndTypeTextInField(passwordTxtInputField, userPassword);
    }

    public void confirmPassword(String userConfirmPassword) {
        waitAndTypeTextInField(confirmPasswordTxtInputField, userConfirmPassword);
    }

    public void clickOnRegisterSubmitBtn(){
        waitAndClickOnWebElement(registrationFormSubmitBtn);
    }
}
