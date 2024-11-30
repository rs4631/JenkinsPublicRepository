package org.example;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.utils.ReportingUtils;

import java.io.IOException;

public class FacebookTest extends BaseClass {


    @Test(priority = 1)
    public void openLoginPage() throws IOException {
        driver.get("https://www.facebook.com/");
        String title = driver.getTitle();
        softAssert.assertEquals("Facebook – log in or sign up", title);
        ReportingUtils.addStep("Opened Facebook URL", driver);
    }

    @Test(priority = 2)
    public void signInInvalid() throws InterruptedException, IOException {

        FacebookHomePage homePage = new FacebookHomePage(driver);
        homePage.enterEmail("bac@34.com");
        Thread.sleep(2000);
        ReportingUtils.addStep("Email ID Entered", driver);

        homePage.enterPassword("3348899@34");
        Thread.sleep(2000);
        ReportingUtils.addStep("Password Entered", driver);

        homePage.clickLogin();
        Thread.sleep(3000);
        ReportingUtils.addStep("Clicked Login Button", driver);


        FacebookLoginPage loginPage = new FacebookLoginPage(driver);
        String message = loginPage.getErrorMessage();
        softAssert.assertTrue(message.contains("The email address you entered isn't connected to an account"));

    }

    @AfterMethod
    public void sleep() throws InterruptedException {
        Thread.sleep(3000);
    }


}
