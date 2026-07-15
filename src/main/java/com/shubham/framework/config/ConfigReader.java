package com.shubham.framework.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    
   private static Properties properties = new Properties();

   private ConfigReader(){ 

    }

    static{
            InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");

        if(inputStream == null){
            System.out.println(inputStream);  
            throw new RuntimeException("config.properties file not found in the classpath");
        }
        try {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
}
    }


public static String getBrowser() {

    String browser = System.getProperty("browser");

    if (browser == null || browser.isBlank()) {
        browser = properties.getProperty("browser");
    }

    return browser;
}
 
public static String getBaseUrl() {

    String url = System.getProperty("baseUrl");

    if (url == null || url.isBlank()) {
        url = properties.getProperty("baseUrl");
    }

    return url;
}


}
