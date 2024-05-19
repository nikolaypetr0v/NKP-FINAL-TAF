package com.skilo.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PostModal extends Iskilo{
    private final WebElement modalElement;

    public PostModal (WebDriver driver, Logger log) {
        super(driver,log);
        this.modalElement = driver.findElement(By.className("post-modal"));
    }

    public boolean isImageVisible() {
        boolean isPostImgVisible = false;

        try {
            WebElement image = modalElement.findElement(By.cssSelector(".post-modal-img img"));
            isPostImgVisible = wait.until(ExpectedConditions.visibilityOf(image)).isDisplayed();
            if(isPostImgVisible){
                log.info("CONFIRMATION # The image in the post is visible.");
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return isPostImgVisible;
    }
    public String getPostUser() {
        WebElement postUser = modalElement.findElement(By.className("post-user"));
        wait.until(ExpectedConditions.visibilityOf(postUser));
        return postUser.getText();
    }
}
