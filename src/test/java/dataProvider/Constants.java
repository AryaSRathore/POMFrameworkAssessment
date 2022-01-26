package dataProvider;

import java.io.*;
import java.util.Properties;


public class Constants {
    private final String propertyFilePath= "configs//Configuration.properties";

    public static String configFileReader(){
        try {
            Properties properties = new Properties();
            InputStream inputStream = new FileInputStream("/Users/arya.singh/IdeaProjects/POMFrameworkAssessment/src/configs/Configurations.properties");
            properties.load(inputStream);
            return properties.getProperty("url");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
