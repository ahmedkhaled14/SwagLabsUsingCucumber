package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CartPage {

    public  By YourCartSpan = By.xpath("//span[contains(.,'Your Cart')]");
    private  By checkout = By.id("checkout");
    WebDriver driver ;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutPage ClickOnCheckout(){
        driver.findElement(checkout).click();
        return new CheckoutPage(driver);
    }


}
