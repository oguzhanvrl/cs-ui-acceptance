package ui.page;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ui.base.BaseTest;
import ui.base.Language;
import ui.pages.LoginPage;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static ui.base.Constants.EMAIL;
import static ui.base.Constants.PASSWORD;

public class SignInPageTest extends BaseTest {

    protected static WebDriver driver;

    LoginPage loginPage;

    @BeforeClass
    public static void beforeClass() {
        setup();
        driver = BaseTest.driver;
        System.out.println("Testler başladı.");
    }

    @AfterClass
    public static void afterClass() {
        closeBrowser();
        System.out.println("Testler sonlandı.");
    }


    //CASE-1
    @Test
    public void shouldLoginWithValidEmailAndPassword() {
        loginPage = new LoginPage(driver, Language.SPAIN);

        loginPage.login(EMAIL, PASSWORD);

        Assert.assertEquals("Geçerli değerler ile giriş yapılmak istenir, kullanıcı bilgileri kontrol edilir.", loginPage.getLoginEmail(), EMAIL);
    }

    //CASE-2
    @Test
    public void shouldNotLoginWithInvalidEmailAndPassword() {
        loginPage = new LoginPage(driver, Language.MEXICO);

        loginPage.login(randomAlphabetic(10), randomAlphabetic(10));

        List<String> expectedErrorMessages = List.of("Please enter a valid e-mail address.");
        Assert.assertTrue("Geçersiz değerler ile giriş yapılmak istenir, hata mesajı ediliyor.", loginPage.getLoginErrorMessages().equals(expectedErrorMessages));
    }

    //CASE-3
    @Test
    public void shouldNotLoginWithEmptyEmailAndPassword() {
        loginPage = new LoginPage(driver, Language.COLOMBIA);

        loginPage.login("", "");

        List<String> expectedErrorMessages = List.of("Required field.", "Required field.");

        Assert.assertTrue("Boş değerler ile giriş yapılmak istenir, hata mesajı ediliyor.", loginPage.getLoginErrorMessages().equals(expectedErrorMessages));
    }
}