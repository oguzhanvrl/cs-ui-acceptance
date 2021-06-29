package ui.pages;

import ui.base.Language;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ui.base.Constants.BASE_URL;

public class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected String baseUrl = BASE_URL;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);

        driver.get(baseUrl);
    }

    public BasePage(WebDriver driver, Language language) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        this.baseUrl = BASE_URL + language.getCode();

        driver.get(baseUrl);
    }
}
