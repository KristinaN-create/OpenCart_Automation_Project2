package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginUser(String email, String pass) {
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-password")).sendKeys(pass);
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    public String getErrorMessage() {
        return driver.findElement(By.cssSelector(".alert-danger")).getText();
    }
}