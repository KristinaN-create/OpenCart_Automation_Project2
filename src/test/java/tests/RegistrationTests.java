package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegistrationTests extends BaseTest {

    // 1. ПОДАТОЦИ ЗА ТЕСТОТ (Data Provider)
    @DataProvider(name = "registrationData")
    public Object[][] getRegData() {
        return new Object[][] {
                { "Marko", "Markovski", "marko_test" + System.currentTimeMillis() + "@mail.com", "070111222", "Lozinka123!" },
                { "Ana", "Anovska", "ana_test" + System.currentTimeMillis() + 1 + "@mail.com", "070333444", "Lozinka123!" },
                { "Ivan", "Ivanovski", "ivan_test" + System.currentTimeMillis() + 2 + "@mail.com", "070555666", "Lozinka123!" }
        };
    }

    // ТЕСТ 1, 2 и 3 (Автоматски се пушта 3 пати со податоците погоре)
    @Test(dataProvider = "registrationData", priority = 1)
    public void testSuccessfulRegistration(String fName, String lName, String email, String phone, String pass) {
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        homePage.navigateToRegister();
        registerPage.registerUser(fName, lName, email, phone, pass);

        Assert.assertTrue(driver.getTitle().contains("Your Account Has Been Created!"),
                "Регистрацијата не успеа за: " + email);
    }

    // ТЕСТ 4: Проверка за веќе постоечки е-маил
    @Test(priority = 2)
    public void testRegistrationWithExistingEmail() {
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        homePage.navigateToRegister();

        // Овој меил треба веќе да постои за да фрли грешка
        registerPage.registerUser("Test", "User", "test_qa_user@mail.com", "070000000", "Lozinka123!");

        String error = registerPage.getErrorMessage();
        Assert.assertEquals(error, "Warning: E-Mail Address is already registered!",
                "Не се појави точната порака за грешка!");
    }
}