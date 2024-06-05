package gui.regression.registration;

import com.skilo.POM.HomePage;
import com.skilo.POM.LoginPage;
import com.skilo.POM.RegistrationPage;
import gui.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utils.ContentGeneration.*;

public class UserRegistrationHappyTest extends TestBase {
    public static final int WAIT = 2000;

    //Web elements locators
    public static final String LOGIN_PAGE_HEADER_TXT_LOCATOR = "Sign in";
    public static final String REG_PAGE_HEADER_TXT_LOCATOR = "Sign up";

    //Valid user registration data
    public static final String REG_USERNAME = createUser();
    public static final String REG_PASSWORD = createPassword();
    public static final String REG_EMAIL = createEmail();

    @Test
    public void verifyUserCanRegisterWithValidData() throws InterruptedException {
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

        registrationPage.provideUsername(REG_USERNAME);
        log.info("STEP 5: The user has provided a valid username for registration");
        sleepy(WAIT);

        registrationPage.provideEmail(REG_EMAIL);
        log.info("STEP 6: The user has provided a valid email for registration");
        sleepy(WAIT);

        registrationPage.providePassword(REG_PASSWORD);
        log.info("STEP 7: The user has provided a valid password for registration");
        sleepy(WAIT);

        registrationPage.confirmPassword(REG_PASSWORD);
        log.info("STEP 8: The user has provided a valid confirmed password for registration");
        sleepy(WAIT);

        registrationPage.clickOnRegisterSubmitBtn();
        log.info("STEP 9: The user has clicked on the register submit button");
        sleepy(WAIT);

        isLogOutBtnVisible = homePage.isLogOutBtnShown();
        Assert.assertTrue(isLogOutBtnVisible);
        log.info("STEP 10: The user is successfully registered and logged in!");
    }
}
