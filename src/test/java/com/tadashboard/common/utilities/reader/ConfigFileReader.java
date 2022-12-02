package com.tadashboard.common.utilities.reader;

import com.tadashboard.common.utilities.Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath = Utilities.getProjectPath() + "//src/test/resources/Configuration.properties";


    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public long getPageLoadTimeout() {
        String pageLoadTimeout = properties.getProperty("pageLoadTimeout");
        if (pageLoadTimeout != null) return Long.parseLong(pageLoadTimeout);
        else throw new RuntimeException("pageLoadTimeout not specified in the Configuration.properties file.");
    }

    public String getUsername() {
        String username = properties.getProperty("username");
        if (username != null) return username;
        else throw new RuntimeException("username not specified in the Configuration.properties file.");
    }

    public String getBrowserDriver() {
        String browser = properties.getProperty("browser");
        if (browser != null) return browser;
        else throw new RuntimeException("browser not specified in the Configuration.properties file.");
    }

}
