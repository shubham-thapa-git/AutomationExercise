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


public static String getBrowser(){
    String browser = properties.getProperty("browser");
    if(browser == null){
        throw new RuntimeException("browser property not found in the config.properties file");
    }
    System.out.println(browser);
    return browser;
}
 
public static String getBaseUrl(){
    String baseUrl = properties.getProperty("baseUrl");
    if(baseUrl == null){
        throw new RuntimeException("baseUrl property not found in the config.properties file");
    }
    return baseUrl;
}


}
