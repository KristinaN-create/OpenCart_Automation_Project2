package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTests extends BaseTest {

    @Test(priority = 1)
    public void testSearchForiPhone() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchForProduct("iPhone");
        Assert.assertTrue(searchPage.isProductVisible("iPhone"), "iPhone не е пронајден!");
    }

    @Test(priority = 2)
    public void testSearchForMacBook() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchForProduct("MacBook");
        Assert.assertTrue(searchPage.isProductVisible("MacBook"), "MacBook не е пронајден!");
    }
}