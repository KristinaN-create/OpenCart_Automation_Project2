package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForProduct(String productName) {
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys(productName);
        driver.findElement(By.cssSelector(".btn-default")).click();
    }

    public boolean isProductVisible(String productName) {
        return driver.findElement(By.linkText(productName)).isDisplayed();
    }
}
