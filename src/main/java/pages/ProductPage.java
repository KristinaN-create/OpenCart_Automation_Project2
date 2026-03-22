package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private WebDriver driver;

    private By quantityField = By.id("input-quantity");
    private By addToCartButton = By.id("button-cart");
    private By successAlert = By.cssSelector(".alert-success");
    private By productTitle = By.cssSelector("h1");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setQuantity(String qty) {
        WebElement qtyInput = driver.findElement(quantityField);
        qtyInput.clear();
        qtyInput.sendKeys(qty);
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    public String getSuccessMessage() {
        return driver.findElement(successAlert).getText();
    }
}