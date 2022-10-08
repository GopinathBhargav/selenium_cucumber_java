package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtils {

    private Properties prop;
    public Properties readPropertyFile() {

        prop = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("./src/test/resources/config.properties");
            prop.load(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return prop;

    }
}
