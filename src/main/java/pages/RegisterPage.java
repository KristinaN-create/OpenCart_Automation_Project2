package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    private By firstNameField = By.id("input-firstname");
    private By lastNameField = By.id("input-lastname");
    private By emailField = By.id("input-email");
    private By telephoneField = By.id("input-telephone");
    private By passwordField = By.id("input-password");
    private By confirmPasswordField = By.id("input-confirm");
    private By privacyPolicyCheckbox = By.name("agree");
    private By continueButton = By.cssSelector(".btn-primary");
    private By errorAlert = By.cssSelector(".alert-danger");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerUser(String fName, String lName, String email, String phone, String pass) {
        driver.findElement(firstNameField).sendKeys(fName);
        driver.findElement(lastNameField).sendKeys(lName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(telephoneField).sendKeys(phone);
        driver.findElement(passwordField).sendKeys(pass);
        driver.findElement(confirmPasswordField).sendKeys(pass);
        driver.findElement(privacyPolicyCheckbox).click();
        driver.findElement(continueButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorAlert).getText();
    }
}