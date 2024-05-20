package gui.regression.profile;

import com.skilo.POM.HomePage;
import com.skilo.POM.LoginPage;
import com.skilo.POM.PostPage;
import com.skilo.POM.ProfilePage;
import gui.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class ProfileHappyTest extends TestBase {
    public static final String LOGIN_PAGE_URL = "users/login";
    public static final int WAIT = 2000;

    @DataProvider(name = "ProfileTestDataProvider")
    public Object[][] getUsers() {
        File profilePicture = new File("src\\test\\resources\\upload\\gandalfTheGray.jpg");

        return new Object[][]{{
                "gandalf", "thegray", profilePicture},
        };
    }
    @Test(dataProvider = "ProfileTestDataProvider")
    public void verifyUserCanUpdateProfilePicture(String user, String password, File file) throws InterruptedException {
        HomePage homePage = new HomePage(super.driver, log);

        LoginPage loginPage = new LoginPage(super.driver, log);
        loginPage.navigateTo(LOGIN_PAGE_URL);
        loginPage.loginWithUserAndPassword(user, password);
        sleepy(WAIT);

        boolean isLogOutBtnVisible = homePage.isLogOutBtnShown();
        Assert.assertTrue(isLogOutBtnVisible);

        homePage.clickOnProfileNavBtn();
        sleepy(WAIT);
        ProfilePage profilePage = new ProfilePage(super.driver, log);
        profilePage.uploadProfilePicture(file);
        sleepy(WAIT);

        Assert.assertTrue(profilePage.isProfilePictureVisible(), "The image is not visible!");
        sleepy(WAIT);
    }
}
