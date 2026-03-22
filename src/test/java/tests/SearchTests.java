package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTests extends BaseTest {

    @Test(dataProvider = "registrationData", priority = 1, groups = {"smoke", "regression"})
    public void testSearchForiPhone() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchForProduct("iPhone");
        Assert.assertTrue(searchPage.isProductVisible("iPhone"), "iPhone не е пронајден!");
    }

    @Test(dataProvider = "registrationData", priority = 2, groups = {"smoke", "regression"})
    public void testSearchForMacBook() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchForProduct("MacBook");
        Assert.assertTrue(searchPage.isProductVisible("MacBook"), "MacBook не е пронајден!");
    }
}