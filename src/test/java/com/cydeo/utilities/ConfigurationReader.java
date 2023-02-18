package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1-Create the properties object
    //make it private so its not accessible outside the class
    //make it static to make sure its created and loaded before everything else.
    private static Properties properties = new Properties();

    static{

        try {
            //2-Open file using FileInputStream (open file)
            FileInputStream file = new FileInputStream("configuration.properties");

            //3-Load the "properties" object with "file" (load properties)
            properties.load(file);
        } catch (IOException e) {
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!");
            e.printStackTrace();
        }
    }

    //CREATE A METHOD TO SE THE OBJECT TO READ
    //4-Use "properties" object to read from the file (read properties)

    public static String getProperty(String keyword){

        return properties.getProperty(keyword);
    }
}
