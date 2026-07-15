package com.shubham.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    

      
    
    private final By loginSignupButton = By.cssSelector("a[href='/login']");






    public HomePage(WebDriver driver){
        super(driver);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public LoginPage clickSignUpLoginButton(){
        driver.findElement(loginSignupButton).click();
        return new LoginPage(driver);
    }
  


    
}
