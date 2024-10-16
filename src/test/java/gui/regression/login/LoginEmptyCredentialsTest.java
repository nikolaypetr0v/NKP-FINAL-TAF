package gui.regression.login;

import com.skilo.POM.HomePage;
import com.skilo.POM.LoginPage;
import gui.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginEmptyCredentialsTest extends TestBase {
    private static final int WAIT = 2000;
    private static final String EMPTY_USERNAME = "";
    private static final String EMPTY_PASSWORD = "";
    private static final String LOGIN_PAGE_HEADER_TXT_LOCATOR = "Sign in";
    private static final String LOGIN_PAGE_USERNAME_PLACEHOLDER_LOCATOR = "Username or email";
    private static final String LOGIN_PAGE_PASSWORD_PLACEHOLDER_LOCATOR = "Password";

    @Test
    public void verifyUserCannotLoginWithoutCredentials() throws InterruptedException {
        HomePage homePage = new HomePage(super.driver, log);
        log.info("STEP 1: Not logged in user opens the ISkillo HomePage.");
        homePage.openHomePage();
        boolean isLogOutBtnVisible = homePage.isLogOutBtnShown();
        Assert.assertFalse(isLogOutBtnVisible);

        homePage.navigateToLoginPageViaClickOnNavLoginBtn();
        log.info("STEP 2: The user has navigated to ISkillo LoginPage");

        LoginPage loginPage = new LoginPage(super.driver, log);
        boolean isLoginPageOpened = loginPage.isLoginPageOpenedPerRequirements(LOGIN_PAGE_HEADER_TXT_LOCATOR);
        Assert.assertTrue(isLoginPageOpened);
        log.info("STEP 3: The user has verified that the LoginPage is open as per requirements ");
        sleepy(WAIT);

        boolean isUsernamePlaceholderValid = loginPage.isUsernamePlaceholderCorrect(LOGIN_PAGE_USERNAME_PLACEHOLDER_LOCATOR);
        Assert.assertTrue(isUsernamePlaceholderValid);
        loginPage.provideUsername(EMPTY_USERNAME);
        log.info("STEP 4: The user has not provided a username");
        sleepy(WAIT);

        boolean isPasswordPlaceholderValid = loginPage.isPasswordPlaceholderCorrect(LOGIN_PAGE_PASSWORD_PLACEHOLDER_LOCATOR);
        Assert.assertTrue(isPasswordPlaceholderValid);
        loginPage.providePassword(EMPTY_PASSWORD);
        log.info("STEP 5: The user has not provided a password");
        sleepy(WAIT);

        loginPage.clickOnRememberMeCheckbox();
        log.info("STEP 6: The user has clicked on \"Remember me\" checkbox");
        sleepy(WAIT);

        loginPage.clickOnLoginSubmitBtn();
        log.info("STEP 7: The user has clicked on login submit button");
        sleepy(WAIT);

        Assert.assertFalse(homePage.isLogOutBtnShown());
        log.info("STEP 8: The user has not logged-in. No username and password provided!");
        sleepy(WAIT);
    }
}
