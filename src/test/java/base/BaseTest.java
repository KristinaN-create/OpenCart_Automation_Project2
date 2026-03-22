package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Collections;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();


        options.addArguments("--incognito");


        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-blink-features=AutomationControlled");


        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();


        ((JavascriptExecutor) driver).executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        driver.get("https://demo.opencart.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

         if (driver != null) {
          driver.quit();
         }
    }
}