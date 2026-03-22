package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {


    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
                { "marko_test1@mail.com", "Lozinka123!" },
                { "ana_test2@mail.com", "Lozinka123!" },
                { "test_qa_user@mail.com", "Lozinka123!" }
        };
    }


    @Test(dataProvider = "registrationData", priority = 1, groups = {"smoke", "regression"})
    public void testSuccessfulLogin(String email, String pass) {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.navigateToLogin();
        loginPage.loginUser(email, pass);


        Assert.assertEquals(driver.getTitle(), "My Account", "Логирањето не успеа за: " + email);
    }


    @Test(dataProvider = "registrationData", priority = 2, groups = {"smoke", "regression"})
    public void testLoginWithInvalidPassword() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.navigateToLogin();
        loginPage.loginUser("test_qa_user@mail.com", "PogreshnaLozinka123");

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Warning: No match for E-Mail Address and/or Password."),
                "Не се појави порака за грешна лозинка!");
    }
}