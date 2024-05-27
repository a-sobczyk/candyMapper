package org.candyMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

public class BaseTest {

    public static Properties PROPERTIES;
    public static WebDriver driver;

    @BeforeAll
    public static void testDataSetup() {
        try {
            File config = new File("configuration.properties");
            FileInputStream configStream = new FileInputStream(config);
            PROPERTIES = new Properties();
            PROPERTIES.load(configStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        WebDriverManager.chromedriver().setup();

        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type");
        options.addArguments("--incognito");
        options.addArguments("--verbose");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        String url = PROPERTIES.getProperty("CANDY_MAPPER_URL");
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
