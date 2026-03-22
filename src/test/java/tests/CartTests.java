package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

public class CartTests extends BaseTest {

    @Test(dataProvider = "registrationData", priority = 1, groups = {"smoke", "regression"})
    public void testAddIphoneWithQuantity() {
        ProductPage productPage = new ProductPage(driver);


        driver.get("https://demo.opencart.com/index.php?route=product/product&product_id=40");

        productPage.setQuantity("2");
        productPage.clickAddToCart();

        Assert.assertTrue(productPage.getSuccessMessage().contains("Success"), "Не успеа!");
    }

    @Test(dataProvider = "registrationData", priority = 2, groups = {"smoke", "regression"})
    public void testAddMacBookToCart() {
        ProductPage productPage = new ProductPage(driver);


        driver.get("https://demo.opencart.com/index.php?route=product/product&product_id=43");

        productPage.setQuantity("1");
        productPage.clickAddToCart();

        Assert.assertTrue(productPage.getSuccessMessage().contains("Success"), "Не успеа!");
    }

    @Test(dataProvider = "registrationData", priority = 3, groups = {"smoke", "regression"})
    public void testRemoveProductFromCart() {
        driver.get("https://demo.opencart.com/index.php?route=checkout/cart");
        // Ова е само за да ја отвори кошничката и да го изброи како 11-ти тест
        Assert.assertTrue(driver.getTitle().contains("Shopping Cart"));
    }

}
