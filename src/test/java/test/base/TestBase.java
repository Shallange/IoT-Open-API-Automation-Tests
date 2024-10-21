package test.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    protected String apiUrl;
    protected int installationId;
    protected String token;

    public TestBase() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/java/test/resources/config.properties")) {
            properties.load(fis);
            this.apiUrl = properties.getProperty("apiUrl");
            this.installationId = Integer.parseInt(properties.getProperty("installationId"));
            this.token = properties.getProperty("token");

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration properties.");
        }
    }
}
