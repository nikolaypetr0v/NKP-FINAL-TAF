package gui.regression.login;

import com.skilo.POM.HomePage;
import com.skilo.POM.LoginPage;
import gui.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginHappyTest extends TestBase {
    //const and vars that will be used in the test case
    private static final String USERNAME = "gandalf";
    private static final String PASSWORD = "thegray";
    private static final String LOGIN_PAGE_HEADER_TXT_LOCATOR = "Sign in";
    private static final String LOGIN_PAGE_USERNAME_PLACEHOLDER_LOCATOR = "Username or email";
    private static final String LOGIN_PAGE_PASSWORD_PLACEHOLDER_LOCATOR = "Password";

    @Test
    public void verifyUserCanLoginViaNavLoginBtn() {
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
        boolean isUsernamePlaceholderValid = loginPage.isUsernamePlaceholderCorrect(LOGIN_PAGE_USERNAME_PLACEHOLDER_LOCATOR);
        Assert.assertTrue(isUsernamePlaceholderValid);
        loginPage.provideUsername(USERNAME);
        log.info("STEP 4: The user has provided a valid username");

        boolean isPasswordPlaceholderValid = loginPage.isPasswordPlaceholderCorrect(LOGIN_PAGE_PASSWORD_PLACEHOLDER_LOCATOR);
        Assert.assertTrue(isPasswordPlaceholderValid);
        loginPage.providePassword(PASSWORD);
        log.info("STEP 5: The user has provided a valid password");

        loginPage.clickOnRememberMeCheckbox();
        log.info("STEP 6: The user has clicked on \"Remember me\" checkbox");

        loginPage.clickOnLoginSubmitBtn();
        log.info("STEP 7: The user has clicked on login submit button");

        Assert.assertTrue(homePage.isLogOutBtnShown());
        log.info("STEP 8: The user has logged-in successfully");
    }
}
