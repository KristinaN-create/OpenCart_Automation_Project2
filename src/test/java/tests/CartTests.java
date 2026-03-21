package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage; // Внимавај, овде користиме ProductPage!

public class CartTests extends BaseTest {

    @Test(priority = 1)
    public void testAddIphoneWithQuantity() {
        ProductPage productPage = new ProductPage(driver);

        // Одиме на iPhone
        driver.get("https://demo.opencart.com/index.php?route=product/product&product_id=40");

        productPage.setQuantity("2");
        productPage.clickAddToCart();

        Assert.assertTrue(productPage.getSuccessMessage().contains("Success"), "Не успеа!");
    }

    @Test(priority = 2)
    public void testAddMacBookToCart() {
        ProductPage productPage = new ProductPage(driver);

        // Одиме на MacBook
        driver.get("https://demo.opencart.com/index.php?route=product/product&product_id=43");

        productPage.setQuantity("1");
        productPage.clickAddToCart();

        Assert.assertTrue(productPage.getSuccessMessage().contains("Success"), "Не успеа!");
    }
}
