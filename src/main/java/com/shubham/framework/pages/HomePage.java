package com.shubham.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    

      
    private final By SignUpLoginButton = By.partialLinkText(" Signup / Login");





    public HomePage(WebDriver driver){
        super(driver);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public LoginPage clickSignUpLoginButton(){
        driver.findElement(SignUpLoginButton).click();
        return new LoginPage(driver);
    }
  


    
}
