package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties property;
    public ConfigFileReader()
    {
       String configFileName = "testconfig.properties";
       FileInputStream fileInputStream = null;

       this.property = new Properties();
       String configFilePath = System.getProperty("user.dir")+"/"+"src/main/resources/config"+"/"+configFileName;
       try {
           fileInputStream = new FileInputStream(configFilePath);
           property.load(fileInputStream);
       }
       catch(FileNotFoundException e)
       {
           e.printStackTrace();
       }
       catch(IOException e){
           e.printStackTrace();
       }



    }
    public String getProperty(String propName){


        return this.property.getProperty(propName);
    }
}
