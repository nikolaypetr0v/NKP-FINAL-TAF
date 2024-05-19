package gui.regression.profile;

import com.skilo.POM.HomePage;
import com.skilo.POM.LoginPage;
import com.skilo.POM.ProfileModalPage;
import com.skilo.POM.ProfilePage;
import gui.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProfileModalHappyTest extends TestBase {
    public static final String LOGIN_PAGE_URL = "users/login";
    public static final int WAIT = 2000;

    //Web elements locators
    public static final String PROFILE_MODAL_HEADER_TXT = "Modify Your Profile";
    public static final String PROFILE_MODAL_USERNAME_LBL_TXT = "Usermame";
    public static final String PROFILE_MODAL_EMAIL_LBL_TXT = "Email";
    public static final String PROFILE_MODAL_PASSWORD_LBL_TXT = "Password";
    public static final String PROFILE_MODAL_CONFIRM_PASSWORD_LBL_TXT = "Confirm password";
    public static final String PROFILE_MODAL_PUBIC_INFO_LBL_TXT = "Public Info";
    public static final String PROFILE_MODAL_SAVE_BTN_TXT = "Save";

    @DataProvider(name = "ProfileModalTestDataProvider")
    public Object[][] getUsers() {
        return new Object[][]{{"gandalf", "thegray"}};
    }

    @Test(dataProvider = "ProfileModalTestDataProvider")
    public void verifyProfileModalLayoutIsPerRequirements(String username, String password) {
        HomePage homePage = new HomePage(super.driver, log);

        LoginPage loginPage = new LoginPage(super.driver, log);
        loginPage.navigateTo(LOGIN_PAGE_URL);
        sleepy(WAIT);
        loginPage.loginWithUserAndPassword(username, password);
        sleepy(WAIT);

        boolean isLogOutBtnVisible = homePage.isLogOutBtnShown();
        Assert.assertTrue(isLogOutBtnVisible);

        homePage.clickOnProfileNavBtn();
        sleepy(WAIT);

        ProfilePage profilePage = new ProfilePage(super.driver, log);
        profilePage.clickOnProfileInfoEditBtn();
        sleepy(WAIT);

        ProfileModalPage profileModalPage = new ProfileModalPage(super.driver, log);
        boolean isProfileModalHeaderValid = profileModalPage.isProfileModalHeaderCorrect(PROFILE_MODAL_HEADER_TXT);
        Assert.assertTrue(isProfileModalHeaderValid);

        boolean isProfileModalUsernameLblValid = profileModalPage.isProfileModalUsernameLblCorrect(PROFILE_MODAL_USERNAME_LBL_TXT);
        Assert.assertTrue(isProfileModalUsernameLblValid);

        boolean isProfileModalEmailLblValid = profileModalPage.isProfileModalEmailLblCorrect(PROFILE_MODAL_EMAIL_LBL_TXT);
        Assert.assertTrue(isProfileModalEmailLblValid);

        boolean isProfileModalPasswordLblValid = profileModalPage.isProfileModalPasswordLblCorrect(PROFILE_MODAL_PASSWORD_LBL_TXT);
        Assert.assertTrue(isProfileModalPasswordLblValid);

        boolean isProfileModalConfirmPasswordLblValid = profileModalPage.isProfileModalConfirmPasswordLblCorrect(PROFILE_MODAL_CONFIRM_PASSWORD_LBL_TXT);
        Assert.assertTrue(isProfileModalConfirmPasswordLblValid);

        boolean isProfileModalPublicInfoLblValid = profileModalPage.isProfileModalPublicInfoLblCorrect(PROFILE_MODAL_PUBIC_INFO_LBL_TXT);
        Assert.assertTrue(isProfileModalPublicInfoLblValid);

        boolean isProfileModalSaveBtnTxtValid = profileModalPage.isProfileModalSaveBtnTxtCorrect(PROFILE_MODAL_SAVE_BTN_TXT);
        Assert.assertTrue(isProfileModalSaveBtnTxtValid);

        log.info("The user has verified that the profile modal layout is per requirements. ");
        sleepy(WAIT);

//        profilePage.modifyProfileUsername("GandalfTheWhite");
//        sleepy(WAIT);
//        profilePage.clickOnProfileModalSaveBtn();
//        sleepy(WAIT);
    }
}
