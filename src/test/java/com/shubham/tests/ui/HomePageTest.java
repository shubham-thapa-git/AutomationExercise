package com.shubham.tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.shubham.framework.pages.HomePage;
import com.shubham.tests.base.BaseTest;

public class HomePageTest extends BaseTest {
    
    
    
    @Test
    public void verifyHomePageTitle(){
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getPageTitle(), "Automation Exercise");
    }
}
