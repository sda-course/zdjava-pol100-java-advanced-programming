package example;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("count", "5");
        properties.setProperty("date","2021-07-30");
        properties.store(new FileWriter("c:\\data\\app.properties"), null);
    }
}
