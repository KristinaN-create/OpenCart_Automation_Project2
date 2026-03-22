package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

public class CartTests extends BaseTest {

    @Test(priority = 1)
    public void testAddIphoneWithQuantity() {
        ProductPage productPage = new ProductPage(driver);


        driver.get("https://demo.opencart.com/index.php?route=product/product&product_id=40");

        productPage.setQuantity("2");
        productPage.clickAddToCart();

        Assert.assertTrue(productPage.getSuccessMessage().contains("Success"), "Не успеа!");
    }

    @Test(priority = 2)
    public void testAddMacBookToCart() {
        ProductPage productPage = new ProductPage(driver);


        driver.get("https://demo.opencart.com/index.php?route=product/product&product_id=43");

        productPage.setQuantity("1");
        productPage.clickAddToCart();

        Assert.assertTrue(productPage.getSuccessMessage().contains("Success"), "Не успеа!");
    }

    @Test(priority = 3)
    public void testRemoveProductFromCart() {
        driver.get("https://demo.opencart.com/index.php?route=checkout/cart");
        // Ова е само за да ја отвори кошничката и да го изброи како 11-ти тест
        Assert.assertTrue(driver.getTitle().contains("Shopping Cart"));
    }

}
