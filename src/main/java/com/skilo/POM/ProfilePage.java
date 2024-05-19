package com.skilo.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

public class ProfilePage  extends Iskilo{
    @FindBy(id = "upload-img")
    private WebElement uploadProfilePictureField;
    @FindBy (css = "img.profile-image-source")
    private WebElement profileImage;
    @FindBy(css = "i.fas.fa-user-edit")
    private WebElement profileInfoEditBtn;

    public ProfilePage(WebDriver driver, Logger log) {
        super(driver,log);
        PageFactory.initElements(driver,this);
    }

    public String getUsername() {
        WebElement username = driver.findElement(By.tagName("h2"));
        return username.getText();
    }

    public int getPostCount() {
        List<WebElement> posts = driver.findElements(By.tagName("app-post"));
        return posts.size();
    }

    public void clickPost(int postIndex) {
        List<WebElement> posts = driver.findElements(By.tagName("app-post"));
        posts.get(postIndex).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
    }

    public void clickOnProfilePicture() {
        wait.until(ExpectedConditions.visibilityOf(profileImage));
        profileImage.click();
    }

    public void clickOnProfileInfoEditBtn(){
        waitAndClickOnWebElement(profileInfoEditBtn);
    }

    public void uploadProfilePicture(File file) {
        uploadProfilePictureField.sendKeys(file.getAbsolutePath());
        log.info("CONFIRMATION # The profile picture file was successfully uploaded");
    }

    public boolean isProfilePictureVisible() {
        boolean isPictureVisible = false;

        try {
            isPictureVisible = wait.until(ExpectedConditions.visibilityOf(profileImage)).isDisplayed();
            if (isPictureVisible) {
                log.info("CONFIRMATION # The profile picture is visible.");
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            log.error("ERROR : The profile picture is not visible");
        }
        return isPictureVisible;
    }
}
