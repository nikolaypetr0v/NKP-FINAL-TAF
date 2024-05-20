package com.skilo.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfileModalPage extends Iskilo {
    @FindBy (xpath = "//input[contains(@formcontrolname, 'username')]")
    private WebElement profileUsernameInputField;
    @FindBy (css = "button.btn.btn-primary")
    private WebElement profileModalSaveBtn;
    @FindBy (xpath = "//div[contains(@class, 'col-md-12 form-header')]/h4")
    private WebElement profileModalHeaderTitle;
    @FindBy (xpath = "(//label[contains(@class, 'col-4')])[1]")
    private WebElement profileModalUsernameLbl;
    @FindBy (xpath = "(//label[contains(@class, 'col-4')])[2]")
    private WebElement profileModalEmailLbl;
    @FindBy (xpath = "(//label[contains(@class, 'col-4')])[3]")
    private WebElement profileModalPasswordLbl;
    @FindBy (xpath = "(//label[contains(@class, 'col-4')])[4]")
    private WebElement profileModalConfirmPasswordLbl;
    @FindBy (xpath = "(//label[contains(@class, 'col-4')])[5]")
    private WebElement profileModalPublicInfoLbl;
    @FindBy (xpath = "//div[contains(@class, 'offset-4 col-8 mt-1')]/button")
    private WebElement profileModalSaveBtnTxt;

    public ProfileModalPage(WebDriver driver, Logger log) {
        super(driver,log);
        PageFactory.initElements(driver,this);
    }

    public String getProfileModalHeader() {
        wait.until(ExpectedConditions.visibilityOf(profileModalHeaderTitle));
        return profileModalHeaderTitle.getText();
    }

    public String getProfileModalUsernameLbl() {
        wait.until(ExpectedConditions.visibilityOf(profileModalUsernameLbl));
        return profileModalUsernameLbl.getText();
    }

    public String getProfileModalEmailLbl() {
        wait.until(ExpectedConditions.visibilityOf(profileModalEmailLbl));
        return profileModalEmailLbl.getText();
    }

    public String getProfileModalPasswordLbl() {
        wait.until(ExpectedConditions.visibilityOf(profileModalPasswordLbl));
        return profileModalPasswordLbl.getText();
    }

    public String getProfileModalConfirmPasswordLbl() {
        wait.until(ExpectedConditions.visibilityOf(profileModalConfirmPasswordLbl));
        return profileModalConfirmPasswordLbl.getText();
    }

    public String getProfileModalPublicInfoLbl() {
        wait.until(ExpectedConditions.visibilityOf(profileModalPublicInfoLbl));
        return profileModalPublicInfoLbl.getText();
    }

    public String getProfileModalSaveBtnTxt() {
        wait.until(ExpectedConditions.visibilityOf(profileModalSaveBtnTxt));
        return profileModalSaveBtnTxt.getText();
    }

    public boolean isProfileModalHeaderCorrect(String expectedProfileModalHeaderTxt) {
        boolean isProfileModalHeaderValid = false;

        try{
            String actualProfileModalHeaderTxt = getProfileModalHeader();
            isProfileModalHeaderValid = expectedProfileModalHeaderTxt.equals(actualProfileModalHeaderTxt);
            if (isProfileModalHeaderValid) {
                System.out.println("There is a match! Actual profile modal header matches the criteria ");
            }
        }
        catch (NoSuchElementException e){
            log.error("ERROR ! The profile modal header is not per requirements.");
        }
        return isProfileModalHeaderValid;
    }

    public boolean isProfileModalUsernameLblCorrect(String expectedProfileModalUsernameLblTxt) {
        boolean isProfileModalUsernameLblValid = false;

        try{
            String actualProfileModalUsernameLblTxt = getProfileModalUsernameLbl();
            isProfileModalUsernameLblValid = expectedProfileModalUsernameLblTxt.equals(actualProfileModalUsernameLblTxt);
            if (isProfileModalUsernameLblValid) {
                System.out.println("There is a match! Actual profile modal 'Username' label matches the criteria ");
            }
        }
        catch (NoSuchElementException e){
            log.error("ERROR ! The profile modal 'Username' label is not per requirements.");
        }
        return isProfileModalUsernameLblValid;
    }

    public boolean isProfileModalEmailLblCorrect(String expectedProfileModalEmailLblTxt) {
        boolean isProfileModalEmailLblValid = false;

        try{
            String actualProfileModalEmailLblTxt = getProfileModalEmailLbl();
            isProfileModalEmailLblValid = expectedProfileModalEmailLblTxt.equals(actualProfileModalEmailLblTxt);
            if (isProfileModalEmailLblValid) {
                System.out.println("There is a match! Actual profile modal 'Email' label matches the criteria ");
            }
        }
        catch (NoSuchElementException e){
            log.error("ERROR ! The profile modal 'Email' label is not per requirements.");
        }
        return isProfileModalEmailLblValid;
    }

    public boolean isProfileModalPasswordLblCorrect(String expectedProfileModalPasswordLblTxt) {
        boolean isProfileModalPasswordLblValid = false;

        try{
            String actualProfileModalPasswordLblTxt = getProfileModalPasswordLbl();
            isProfileModalPasswordLblValid = expectedProfileModalPasswordLblTxt.equals(actualProfileModalPasswordLblTxt);
            if (isProfileModalPasswordLblValid) {
                System.out.println("There is a match! Actual profile modal 'Password' label matches the criteria ");
            }
        }
        catch (NoSuchElementException e){
            log.error("ERROR ! The profile modal 'Password' label is not per requirements.");
        }
        return isProfileModalPasswordLblValid;
    }

    public boolean isProfileModalConfirmPasswordLblCorrect(String expectedProfileModalConfirmPasswordLblTxt) {
        boolean isProfileModalConfirmPasswordLblValid = false;

        try{
            String actualProfileModalConfirmPasswordLblTxt = getProfileModalConfirmPasswordLbl();
            isProfileModalConfirmPasswordLblValid = expectedProfileModalConfirmPasswordLblTxt.equals(actualProfileModalConfirmPasswordLblTxt);
            if (isProfileModalConfirmPasswordLblValid) {
                System.out.println("There is a match! Actual profile modal 'Confirm password' label matches the criteria ");
            }
        }
        catch (NoSuchElementException e){
            log.error("ERROR ! The profile modal 'Confirm password' label is not per requirements.");
        }
        return isProfileModalConfirmPasswordLblValid;
    }

    public boolean isProfileModalPublicInfoLblCorrect(String expectedProfileModalPublicInfoLblTxt) {
        boolean isProfileModalPublicInfoLblValid = false;

        try{
            String actualProfileModalPublicInfoLblTxt = getProfileModalPublicInfoLbl();
            isProfileModalPublicInfoLblValid = expectedProfileModalPublicInfoLblTxt.equals(actualProfileModalPublicInfoLblTxt);
            if (isProfileModalPublicInfoLblValid) {
                System.out.println("There is a match! Actual profile modal 'Public Info' label matches the criteria ");
            }
        }
        catch (NoSuchElementException e){
            log.error("ERROR ! The profile modal 'Public Info' label is not per requirements.");
        }
        return isProfileModalPublicInfoLblValid;
    }

    public boolean isProfileModalSaveBtnTxtCorrect(String expectedProfileModalSaveBtnTxt) {
        boolean isProfileModalSaveBtnTxtValid = false;

        try{
            String actualProfileModalSaveBtnTxt = getProfileModalSaveBtnTxt();
            isProfileModalSaveBtnTxtValid = expectedProfileModalSaveBtnTxt.equals(actualProfileModalSaveBtnTxt);
            if (isProfileModalSaveBtnTxtValid) {
                System.out.println("There is a match! Actual profile modal 'Save' button text matches the criteria ");
            }
        }
        catch (NoSuchElementException e){
            log.error("ERROR ! The profile modal 'Save' button text is not per requirements.");
        }
        return isProfileModalSaveBtnTxtValid;
    }

    public void clickOnProfileModalSaveBtn() {
        waitAndClickOnWebElement(profileModalSaveBtn);
    }

    public void modifyProfileUsername(String username) {
        waitAndTypeTextInField(profileUsernameInputField, username);
    }
}
