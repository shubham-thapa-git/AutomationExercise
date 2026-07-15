package com.shubham.tests.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.shubham.framework.config.ConfigReader;
import com.shubham.framework.driver.DriverManager;
import com.shubham.framework.factory.BrowserFactory;

public class BaseTest {
    
    protected WebDriver driver;
    
    @BeforeMethod
    public void setUp(){
        // Initialize WebDriver here using BrowserFactory and ConfigReader
        String browser = ConfigReader.getBrowser();
        driver = BrowserFactory.createDriver(browser);
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
        driver.get(ConfigReader.getBaseUrl()); 
    }

    @AfterMethod
    public void tearDown(){
        try {
            if (driver != null) {
                driver.quit();
            }
        } finally {
            DriverManager.unload();
        }

}
}
