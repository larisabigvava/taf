package com.epam.taf.properties;

import org.apache.commons.io.FilenameUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyProvider {

    private static Properties loadProperties(String fileName) {
        String filePath = FilenameUtils.separatorsToSystem(
                new File("").getAbsolutePath() + "\\src\\main\\java\\com\\epam\\taf\\resources\\"+ fileName + ".properties");
        File localFile = new File(filePath);
        Properties properties = new Properties();
        if (!localFile.isDirectory()) {
            try {
                FileInputStream fis = new FileInputStream(localFile.getAbsolutePath());
                properties.load(fis);
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Exception during loading properties-file " + filePath);
            }
        }
        return properties;
    }

    public static String getProperty(String fileName, String property) {
        Properties properties = loadProperties(fileName);
        String propertyValue = "";
        if ((System.getProperty(property) != null)) {
            propertyValue = System.getProperty(property);
        } else {
            propertyValue = properties.getProperty(property);
        }
        return propertyValue;
    }
}
