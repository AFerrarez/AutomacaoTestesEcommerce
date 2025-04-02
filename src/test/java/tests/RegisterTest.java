package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//
//public class RegisterTest {
//
//    private WebDriver driver;
//    WebDriverWait wait;

//
//    @BeforeEach
//    public void setup() {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.get("https://automationexercise.com");
//        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//    }
//
//
//    @Test
//    public void testRegisterWithNewCredentials() throws InterruptedException, IOException {
//        HomePage homePage = new HomePage(driver);
//        homePage.clickLoginButton();
//
//        RegisterPage registerPage = new RegisterPage(driver);
//        registerPage.signUp();
//        registerPage.register();
//        assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/account_created");
//
//        captureScreenshot("Success SignIn.png");
//
//    }
//
//
//    @Test
//    public void testLoginWithValidCredentials() throws InterruptedException, IOException {
//        HomePage homePage = new HomePage(driver);
//        homePage.clickLoginButton();
//        LoginPage loginPage = new LoginPage(driver);
//
//        loginPage.enterEmail("usuario_demo@gmail.com");
//        loginPage.enterPassword("Password123456");
//        loginPage.clickLoginButton();
//
//        WebElement LoggedIn = driver.findElement(By.partialLinkText("Logged in"));
//        assertTrue(LoggedIn.isDisplayed());
//
//        captureScreenshot("Success LogIn.png");
////        RegisterPage registerPage = new RegisterPage(driver);
////        registerPage.deletAccount();
//    }
//
//    @Test
//    public void testLoginWithInvalidEmailOrPassword() throws InterruptedException, IOException {
//        HomePage homePage = new HomePage(driver);
//        homePage.clickLoginButton();
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterEmail("usuariodemo@gmail.com");
//        loginPage.enterPassword("Password123456");
//        loginPage.clickLoginButton();
//
//        WebElement message = driver.findElement(By.cssSelector("p[style='color: red;']"));
//        assertEquals(message.getText(), "Your email or password is incorrect!");
//
//        captureScreenshot("login_error.png");
//
//    }
//
//    public void captureScreenshot(String fileName) throws IOException {
//        // Tirando a screenshot
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        FileUtils.copyFile(screenshot, new File("screenshots/" + fileName));
//    }
//
//
//
//    @AfterEach
//    public void tearDown() throws InterruptedException {
//        driver.quit();
//    }
//
//}

//public class RegisterTest {
//
//    private WebDriver driver;
//    WebDriverWait wait;
//    File cookieFile = new File("cookies.data");
//
//    @BeforeEach
//    public void setup() {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.get("https://automationexercise.com");
//        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//    }
//
//    @Test
//    public void testRegisterWithNewCredentials() throws InterruptedException, IOException {
//        HomePage homePage = new HomePage(driver);
//        RegisterPage registerPage = new RegisterPage(driver);
//        homePage.clickLoginButton();
//
//        LoginPage loginPage = new LoginPage(driver);
//        String email = "usuario_demo@gmail.com";
//        String password = "Password123456";
//
//        // Tenta fazer login com o usuário existente
//        if (attemptLogin(email, password)) {
//            // Se o login for bem-sucedido, deleta a conta
//            System.out.println("Usuário logado com sucesso. Deletando a conta...");
//            registerPage.deleteAccount();
//        } else {
//            System.out.println("Usuário não encontrado, continuando com o registro.");
//        }
//
//        // Agora, cria um novo usuário
//
//        registerPage.signUp();
//        registerPage.register();
//
//        // Verifica se a conta foi criada com sucesso
//        assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/account_created");
//        captureScreenshot("Success_SignUp.png");
//    }
//
//    // Metodo para tentar fazer login
//    private boolean attemptLogin(String email, String password) {
//        try {
//            LoginPage loginPage = new LoginPage(driver);
//            loginPage.enterEmail(email);
//            loginPage.enterPassword(password);
//            loginPage.clickLoginButton();
//
//            // Se o login for bem-sucedido, o usuário estará logado
//            WebElement loggedInElement = driver.findElement(By.partialLinkText("Logged in"));
//            return loggedInElement.isDisplayed();  // Se o "Logged in" aparecer, o usuário está logado
//        } catch (NoSuchElementException e) {
//            return false;  // Se o "Logged in" não aparecer, o usuário não está logado
//        }
//    }
//
//    // Metodo para capturar a screenshot
//    public void captureScreenshot(String fileName) throws IOException {
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(screenshot, new File("screenshots/" + fileName));
//    }
//
//    @AfterEach
//    public void tearDown() {
//        driver.quit();
//    }
//}


public class RegisterTest {

    private WebDriver driver;
    WebDriverWait wait;
    File cookieFile = new File("cookies.data");

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
    public void testRegisterWithNewCredentials() throws InterruptedException, IOException {
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        homePage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        String email = "usuario_demo@gmail.com";
        String password = "Password123456";

        // Tenta fazer login com o usuário existente
        if (attemptLogin(email, password)) {
            // Se o login for bem-sucedido, deleta a conta
            System.out.println("Usuário logado com sucesso. Deletando a conta...");
            registerPage.deleteAccount();

            //navegar de volta para a página de login
            driver.get("https://automationexercise.com/login"); // Redireciona para a página de login
        } else {
            System.out.println("Usuário não encontrado, continuando com o registro.");
        }

        // Agora, cria um novo usuário
        registerPage.signUp();
        registerPage.register();

        // Verifica se a conta foi criada com sucesso
        assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/account_created");
        captureScreenshot("Success_SignUp.png");
    }

    // tentar fazer login
    private boolean attemptLogin(String email, String password) {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();

            // Se o login for bem-sucedido, o usuário estará logado
            WebElement loggedInElement = driver.findElement(By.partialLinkText("Logged in"));
            return loggedInElement.isDisplayed();  // Se o "Logged in" aparecer, o usuário está logado
        } catch (NoSuchElementException e) {
            return false;  // Se o "Logged in" não aparecer, o usuário não está logado
        }
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