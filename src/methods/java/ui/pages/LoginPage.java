package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.base.Language;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoginPage extends BasePage {

    public WebDriver driver;

    String loginUrl = "";
    String loginPath = "/login";

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.loginUrl = baseUrl + Language.SPAIN;
    }

    public LoginPage(WebDriver driver, Language language) {
        super(driver, language);
        this.driver = driver;
        this.loginUrl = baseUrl + loginPath;
    }

    public void login(String username, String password) {
        driver.get(loginUrl);

        WebElement userInput = driver.findElement(By.id("EmailLogin"));
        userInput.sendKeys(username);

        WebElement userPasswordInput = driver.findElement(By.id("Password"));
        userPasswordInput.sendKeys(password);

        WebElement signInButton = driver.findElement(By.className("js-login-button"));
        signInButton.click();
    }

    public List<String> getLoginErrorMessages() {
        List<String> errorMessages = new ArrayList<>(List.of(getEmailErrorMessage(), getPasswordErrorMessage()));
        errorMessages.removeAll(Collections.singleton(""));

        return errorMessages;
    }

    public String getEmailErrorMessage() {
        try {
            WebElement emailLoginError = driver.findElement(By.xpath("//span[@id='EmailLogin-error']"));

            return emailLoginError.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public String getPasswordErrorMessage() {
        try {
            WebElement passwordLoginError = driver.findElement(By.xpath("//span[@id='Password-error']"));

            return passwordLoginError.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public String getActiveUserEmail() {
        try {
            WebElement profileButton = driver.findElement(By.xpath("//nav[@class='user-menu']//li[@class='user-menu__item user-menu__item--account']"));
            profileButton.click();

            WebElement profileInformationButton = driver.findElement(By.xpath("//a[contains(@href, 'account/edit-information')]"));
            profileInformationButton.click();

            WebElement emailInput = driver.findElement(By.xpath("//input[@id='Email']"));
            return emailInput.getAttribute("value");
        } catch (NoSuchElementException ex) {
            return "";
        }

    }

    public Boolean isLogOutButtonEnabled() {
        try {
            return driver.findElement(By.xpath("//div[@class='header__bottom']//a[@title='Logout']")).isEnabled();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
