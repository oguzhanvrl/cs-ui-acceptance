package ui.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import static ui.base.Constants.BASE_URL;
import static ui.base.Constants.TIMEOUT;

public abstract class BaseTest {

    protected static WebDriver driver;

    @BeforeSuite
    public static void setup() {
        System.out.println(System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/acceptance-tests/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

        openBrowser();
    }

    public static void openBrowser() {
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public static void closeBrowser() {
        driver.close();
    }
}
