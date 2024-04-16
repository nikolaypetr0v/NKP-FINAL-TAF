package com.skilo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Iskilo {
    //1.Static vars
    public static final String HOME_PAGE_URL = "http://training.skillo-bg.com:4300/posts/all";

    //2.WebElements \\ UI Mappings
    @FindBy (id = "nav-link-login")
    private WebElement navigationLoginButton;

    //3.Constructor
    public HomePage (WebDriver driver) {
        super(driver);
        // Please do not forget to init Page Factory elements
        PageFactory.initElements(driver,this);
    }

    //4.UserActions
    public void openHomePage () {
     this.driver.get(HOME_PAGE_URL);
     wait.until(ExpectedConditions.urlContains(HOME_PAGE_URL));
    }

    public void navigateToLoginPageViaClickOnNavigationLoginButton(){
        waitAndClick(navigationLoginButton);
    }

    //5. Assertions


    //6.Support verification methods
    private void waitAndClick(WebElement elm) {
        wait.until(ExpectedConditions.visibilityOf(elm));
        elm.click();
        System.out.println("THE USER HAS CLICKED ON "+ elm);
    }

}
