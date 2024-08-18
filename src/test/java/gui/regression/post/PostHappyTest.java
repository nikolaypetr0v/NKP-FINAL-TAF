package gui.regression.post;

import com.skilo.POM.*;
import gui.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;

public class PostHappyTest extends TestBase {
    private static final int WAIT = 2000;
    private static final String LOGIN_PAGE_URL = "users/login";

    @DataProvider(name = "PostTestDataProvider")
    public Object[][] getUsers() {
        File postPicture = new File("src\\test\\resources\\upload\\testUpload.jpg");
        String caption = "Testing create post caption";

        return new Object[][]{{
                "gandalf", "thegray",
                "gandalf", postPicture, caption},
        };
    }

    @Test(dataProvider = "PostTestDataProvider")
    public void verifyUserCanCreateNewPost(String user, String password, String username, File file, String caption) throws InterruptedException {
        HomePage homePage = new HomePage(super.driver, log);

        LoginPage loginPage = new LoginPage(super.driver, log);
        loginPage.navigateTo(LOGIN_PAGE_URL);
        sleepy(WAIT);
        loginPage.loginWithUserAndPassword(user, password);

        boolean isLogOutBtnVisible = homePage.isLogOutBtnShown();
        Assert.assertTrue(isLogOutBtnVisible);
        sleepy(WAIT);

        homePage.clickOnNavBtnForNewPost();
        sleepy(WAIT);
        PostPage postPage = new PostPage(super.driver, log);
        postPage.uploadPicture(file);
        sleepy(WAIT);

        Assert.assertTrue(postPage.isImageVisible(), "The image is not visible!");
        Assert.assertEquals(file.getName(), postPage.getImageName(), "The image name is incorrect!");

        postPage.providePostCaption(caption);
        sleepy(WAIT);
        postPage.clickCreatePostButton();
        sleepy(WAIT);

        ProfilePage profilePage = new ProfilePage(super.driver, log);
        Assert.assertEquals(profilePage.getPostCount(), 2, "The number of posts is incorrect!");
        profilePage.clickPost(1);
        sleepy(WAIT);

        PostModal postModal = new PostModal(super.driver, log);
        Assert.assertTrue(postModal.isImageVisible(), "The image in the post is not visible!");
        Assert.assertEquals(postModal.getPostUser(), username);
    }
}
