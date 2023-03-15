package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    public  By shoppingCartLocator = By.id("shopping_cart_container");
    private final By Product1 = By.id("add-to-cart-sauce-labs-backpack");
    private final By Product2 = By.id("add-to-cart-sauce-labs-bike-light");
    private final By CartIcon = By.id("shopping_cart_container");


    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }


    public CartPage AddProductsToTheCart(){
        driver.findElement(Product1).click();
        driver.findElement(Product2).click();
        driver.findElement(CartIcon).click();
        return new CartPage(driver);

    }


}
