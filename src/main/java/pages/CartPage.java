package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void addToCart(String productName) {
        // Наоѓа копче "Add to Cart" за специфичен производ (на пр. iPhone)
        By productCartBtn = By.xpath("//a[text(🙁'" + productName + "']/../../following-sibling::div[@class='button-group']/button[contains(@onclick, 'cart.add')]");
        driver.findElement(productCartBtn).click();
    }

    public String getSuccessMessage() {
        // Чека да се појави зелената порака за успех
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success"))).getText();
    }

    public void openCart() {
        driver.findElement(By.id("cart-total")).click();
        driver.findElement(By.xpath("//strong[contains(.,'View Cart')]")).click();
    }
}