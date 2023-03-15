package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class loginPage {
    private final String URL = "https://www.saucedemo.com/?ref=hackernoon.com" ;
    private final By UserName = By.id("user-name");
    private final By Password = By.id("password");
    private final By Login = By.id("login-button");
    private WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void Setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void navigateToSwaglabsURL() {
        driver.get(URL);
    }

    public ProductsPage FillUserNameAndPassword(String userName , String password){
        driver.findElement(UserName).sendKeys(userName);
        driver.findElement(Password).sendKeys(password);
        driver.findElement(Login).click();
        return new ProductsPage(driver);
    }
}
