package com.shubham.tests.ui;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.shubham.tests.base.BaseTest;

public class SmokeTest extends BaseTest{
    
   
   
    public void smokeTest(){
        Assert.assertEquals(driver.getTitle(), "Automation Exercise");
    }
}
