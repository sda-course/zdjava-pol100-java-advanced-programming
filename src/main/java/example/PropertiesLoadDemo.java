package example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoadDemo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("c:\\data\\app.properties"));
        String date = properties.getProperty("date");
        String countStr = properties.getProperty("count");
        System.out.println(properties.values());
        System.out.println(date);
        System.out.println(countStr);
    }
}
