package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Elemento de login
    private By loginButton = By.xpath("//a[@href='/login']");

    // Método para clicar no botão de login
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
