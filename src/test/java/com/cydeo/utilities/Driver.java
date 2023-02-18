package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    //create a private constructor to remove acess to this object
    private Driver(){}

    /*
    We MAKE wEBdRIVER PRIVATE, BECAUSE WE WANT TO CLOSE ACCESS FROM OUTSIDE OF THE CLASS
     We are making static, because we will use it in a static method
     */

    private static WebDriver driver;//default value = null

    /*
    Create a re-usable utility method which will return the same driver instance once we call it.
    - If an instance doesn't exist, it will create first, and then it will always return the same instance.
     */




    public static WebDriver getDriver(){

        if(driver == null){
            /*
            We will read our browser type from configuration.properties file,
            to control which browser is opened from outside our code.
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browserType returned from the configuration.properties
            switch statement will determine the "case", and open the maching browser.
             */
            switch(browserType){
                case"chrome":
                   // WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
            }



        }

        return driver;
    }


    public static void closeDriver(){
        if(driver!=null){
            driver.quit(); //this line terminates the current driver completely. Driver will not exist going forward
            driver = null; //We assign value back to null so that my singleton can create a newer one if needed
        }
    }
}
