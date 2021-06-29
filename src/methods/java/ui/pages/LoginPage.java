package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.base.Language;

import java.util.List;
import java.util.NoSuchElementException;

public class LoginPage extends BasePage {

    public WebDriver driver;

    String loginUrl = "";
    String loginPath = "/login";

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
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
        return List.of(getEmailErrorMessage(), getPasswordErrorMessage());
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

    public String getLoginEmail() {
        driver.get(baseUrl + "/account/edit-information");

        return driver.findElement(By.xpath("//input[@id='Email']")).getText();
    }
}
