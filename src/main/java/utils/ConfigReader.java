package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    protected static Properties properties = new Properties();
    static {
        try {
            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config/config.properties");
            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String get(String key) {
 return properties.getProperty(key);
    }
}
