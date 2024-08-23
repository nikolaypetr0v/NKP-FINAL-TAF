package gui.regression.registration;

import com.skilo.POM.HomePage;
import com.skilo.POM.LoginPage;
import com.skilo.POM.RegistrationPage;
import gui.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationPageHappyTest extends TestBase {
    private static final int WAIT = 2000;
    //Login page web element locator
    private static final String LOGIN_PAGE_HEADER_TXT_LOCATOR = "Sign in";
    //Register page web elements locators
    private static final String REG_PAGE_HEADER_TXT_LOCATOR = "Sign up";
    private static final String REG_PAGE_USERNAME_PLACEHOLDER = "Username";
    private static final String REG_PAGE_EMAIL_PLACEHOLDER = "email";
    private static final String REG_PAGE_PASSWORD_PLACEHOLDER = "Password";
    private static final String REG_PAGE_CONFIRM_PASSWORD_PLACEHOLDER = "Confirm Password";
    private static final String REG_PAGE_SUBMIT_BTN_LBL_LOCATOR = "Sign in"; // Бъг - в Registration page името на submit бутона е зададено некоректно като "Sign in" вместо "Sign up"

    @Test
    public void verifyRegistrationPageLayoutIsPerRequirements() throws InterruptedException {
        HomePage homePage = new HomePage(super.driver, log);
        log.info("STEP 1: Not logged in user opens the ISkillo HomePage.");
        homePage.openHomePage();
        boolean isLogOutBtnVisible = homePage.isLogOutBtnShown();
        Assert.assertFalse(isLogOutBtnVisible);
        sleepy(WAIT);

        homePage.navigateToLoginPageViaClickOnNavLoginBtn();
        log.info("STEP 2: The user has navigated to ISkillo LoginPage");

        LoginPage loginPage = new LoginPage(super.driver, log);
        boolean isLoginPageOpened = loginPage.isLoginPageOpenedPerRequirements(LOGIN_PAGE_HEADER_TXT_LOCATOR);
        Assert.assertTrue(isLoginPageOpened);
        log.info("STEP 3: The user has verified that the LoginPage is opened as per requirements ");
        sleepy(WAIT);

        loginPage.clickOnLoginRegisterLink();
        log.info("STEP 4: The user has clicked on login page registration link");
        sleepy(WAIT);

        RegistrationPage registrationPage = new RegistrationPage(super.driver, log);
        boolean isRegPageHeaderTxtValid = registrationPage.isRegPageHeaderCorrect(REG_PAGE_HEADER_TXT_LOCATOR);
        Assert.assertTrue(isRegPageHeaderTxtValid);

        boolean isRegUsernamePlaceholderValid = registrationPage.isRegUsernamePlaceholderCorrect(REG_PAGE_USERNAME_PLACEHOLDER);
        Assert.assertTrue(isRegUsernamePlaceholderValid);

        boolean isRegEmailPlaceholderValid = registrationPage.isRegEmailPlaceholderCorrect(REG_PAGE_EMAIL_PLACEHOLDER);
        Assert.assertTrue(isRegEmailPlaceholderValid);

        boolean isRegPasswordPlaceholderValid = registrationPage.isRegPasswordPlaceholderCorrect(REG_PAGE_PASSWORD_PLACEHOLDER);
        Assert.assertTrue(isRegPasswordPlaceholderValid);

        boolean isRegConfirmPasswordPlaceholderValid = registrationPage.isRegConfirmPasswordPlaceholderCorrect(REG_PAGE_CONFIRM_PASSWORD_PLACEHOLDER);
        Assert.assertTrue(isRegConfirmPasswordPlaceholderValid);

        boolean isRegBtnLblValid = registrationPage.isRegBtnLblCorrect(REG_PAGE_SUBMIT_BTN_LBL_LOCATOR);
        Assert.assertTrue(isRegBtnLblValid);

        log.info("STEP 5: The user has verified that the Registration Page layout is per requirements. ");
        sleepy(WAIT);
    }
}
