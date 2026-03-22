package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegistrationTests extends BaseTest {


    @DataProvider(name = "registrationData")
    public Object[][] getRegData() {
        return new Object[][] {
                { "Marko", "Markovski", "marko_test" + System.currentTimeMillis() + "@mail.com", "070111222", "Lozinka123!" },
                { "Ana", "Anovska", "ana_test" + System.currentTimeMillis() + 1 + "@mail.com", "070333444", "Lozinka123!" },
                { "Ivan", "Ivanovski", "ivan_test" + System.currentTimeMillis() + 2 + "@mail.com", "070555666", "Lozinka123!" }
        };
    }


    @Test(dataProvider = "registrationData", priority = 1, groups = {"smoke", "regression"})
    public void testSuccessfulRegistration(String fName, String lName, String email, String phone, String pass) {
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        homePage.navigateToRegister();
        registerPage.registerUser(fName, lName, email, phone, pass);

        Assert.assertTrue(driver.getTitle().contains("Your Account Has Been Created!"),
                "Регистрацијата не успеа за: " + email);
    }


    @Test(dataProvider = "registrationData", priority = 2, groups = {"smoke", "regression"})
    public void testRegistrationWithExistingEmail() {
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        homePage.navigateToRegister();


        registerPage.registerUser("Test", "User", "test_qa_user@mail.com", "070000000", "Lozinka123!");

        String error = registerPage.getErrorMessage();
        Assert.assertEquals(error, "Warning: E-Mail Address is already registered!",
                "Не се појави точната порака за грешка!");
    }
}