package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    // Локатори според барањата на проектот
    private By searchBox = By.name("search");
    private By searchButton = By.cssSelector("#search button");
    private By myAccountLink = By.linkText("My Account");
    private By registerLink = By.linkText("Register");
    private By loginLink = By.linkText("Login");

    public HomePage(WebDriver driver) { this.driver = driver; }

    public void searchProduct(String productName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public void navigateToRegister() {
        driver.findElement(myAccountLink).click();
        driver.findElement(registerLink).click();
    }

    public void navigateToLogin() {
        driver.findElement(myAccountLink).click();
        driver.findElement(loginLink).click();
    }
}