package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Localizadores dos campos de login
    private By emailField = By.cssSelector("input[data-qa='login-email']");
    private By passwordField = By.cssSelector("input[data-qa='login-password']");
    private By loginButton = By.cssSelector("button[data-qa='login-button']");

    // Método para preencher o campo de email
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    //preencher o campo de senha
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    //clicar no botão de login
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    //obter a mensagem de erro
    private By errorMessage = By.xpath("//p[text()='Your email or password is incorrect!']");



    public String getErrorMessage() {
        WebElement errorElement = driver.findElement(errorMessage);

        if (errorElement.isDisplayed()) {
            return errorElement.getText().trim();
        } else {
            return "";
        }
    }
}