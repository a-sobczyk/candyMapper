package org.candyMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    protected static final Logger log = LogManager.getLogger();
    public static Properties PROPERTIES;
    public static WebDriver driver;

    @BeforeAll
    public static void testDataSetup() {
        log.info("Inicjalizajca drivera.");
        try {
            File config = new File("configuration.properties");
            FileInputStream configStream = new FileInputStream(config);
            PROPERTIES = new Properties();
            PROPERTIES.load(configStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
        log.info("Koniec testu.\n\n");
        driver.quit();
    }
}
