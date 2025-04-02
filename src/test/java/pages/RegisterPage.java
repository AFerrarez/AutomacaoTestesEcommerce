package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameField = By.cssSelector("input[data-qa='signup-name']");
    private By emailField = By.cssSelector("input[data-qa='signup-email']");
    private By signUpButton = By.cssSelector("button[data-qa='signup-button']");

    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By company = By.id("company");

    private By idGender = By.id("uniform-id_gender1");
    private By passwordField = By.id("password");
    private By DayOfBith = By.id("days");
    private By MonthOfBith = By.id("months");
    private By YearOfBith = By.id("years");
    private By adress = By.id("address1");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By phone = By.id("mobile_number");
    private By createAccountBtn = By.cssSelector("button[data-qa='create-account']");


    private By deleteAccountBtn = By.linkText("Delete Account");




    public void register() throws InterruptedException {
        driver.findElement(idGender).click();
        driver.findElement(passwordField).sendKeys("Password123456");
        Select birthday = new Select(driver.findElement(DayOfBith));
        birthday.selectByValue("17");
        Select month = new Select(driver.findElement(MonthOfBith));
        month.selectByIndex(3);
        Select year = new Select(driver.findElement(YearOfBith));
        year.selectByValue("2003");
        driver.findElement(firstName).sendKeys("Usuario");
        driver.findElement(lastName).sendKeys("Demonstrativo");
        driver.findElement(company).sendKeys("Incorporation LTDA");
        driver.findElement(adress).sendKeys("Street 4");
        Select countrySelect = new Select(driver.findElement(country));
        countrySelect.selectByValue("United States");
        driver.findElement(state).sendKeys("Virgina");
        driver.findElement(city).sendKeys("Central America");
        driver.findElement(zipcode).sendKeys("123456");
        driver.findElement(phone).sendKeys("987654321");
        driver.findElement(createAccountBtn).click();
    }

    public void signUp() {
        driver.findElement(nameField).sendKeys("Usuario_Demo");
        driver.findElement(emailField).sendKeys("usuario_demo@gmail.com");
        driver.findElement(signUpButton).click();
    }

    public void deleteAccount() throws InterruptedException {
        driver.findElement(deleteAccountBtn).click();
    }



}
