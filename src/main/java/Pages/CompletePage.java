package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage {

    public By Message = By.xpath("//h2[contains(.,'Thank you for your order!')]");
    WebDriver driver ;

    public CompletePage(WebDriver driver) {
        this.driver = driver;
    }
}
