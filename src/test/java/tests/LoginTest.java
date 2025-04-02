package tests;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void testLoginWithValidCredentials() throws InterruptedException, IOException {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("usuario_demo@gmail.com");
        loginPage.enterPassword("Password123456");
        loginPage.clickLoginButton();

        // Verifique se o usuário está logado
        WebElement loggedIn = driver.findElement(By.partialLinkText("Logged in"));
        assertTrue(loggedIn.isDisplayed());

        captureScreenshot("Success_Login.png");
    }

    @Test
    public void testLoginWithInvalidEmailOrPassword() throws InterruptedException, IOException {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("usuariodemo@gmail.com");
        loginPage.enterPassword("Password123456");
        loginPage.clickLoginButton();

        WebElement message = driver.findElement(By.cssSelector("p[style='color: red;']"));
        assertEquals(message.getText(), "Your email or password is incorrect!");

        captureScreenshot("login_error.png");
    }

    //capturar a screenshot
    public void captureScreenshot(String fileName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("screenshots/" + fileName));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}