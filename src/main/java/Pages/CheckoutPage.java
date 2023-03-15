package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private final By FirstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By ZipCode = By.id("postal-code");
    public By Continue = By.id("continue");
    WebDriver driver ;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public OverviewPage FillInformationAndClickOnContinue(String firstName , String LastName, String zipCode){
        driver.findElement(FirstName).sendKeys(firstName);
        driver.findElement(lastName).sendKeys(LastName);
        driver.findElement(ZipCode).sendKeys(zipCode);
        driver.findElement(Continue).click();
        return new OverviewPage(driver);
    }
}
