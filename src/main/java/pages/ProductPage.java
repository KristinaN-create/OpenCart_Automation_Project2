package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private WebDriver driver;

    // Локатори за елементите на поединечна страна на производ
    private By quantityField = By.id("input-quantity");
    private By addToCartButton = By.id("button-cart");
    private By successAlert = By.cssSelector(".alert-success");
    private By productTitle = By.cssSelector("h1");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод за промена на количина
    public void setQuantity(String qty) {
        WebElement qtyInput = driver.findElement(quantityField);
        qtyInput.clear();
        qtyInput.sendKeys(qty);
    }

    // Метод за кликање на копчето за додавање
    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    // Метод за земање на името на продуктот (за проверка)
    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    // Метод за проверка на пораката за успех
    public String getSuccessMessage() {
        return driver.findElement(successAlert).getText();
    }
}