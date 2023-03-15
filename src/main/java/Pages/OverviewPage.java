package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {

    public By finish = By.id("finish");

    WebDriver driver ;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public OverviewPage ClickOnFinish(){
        driver.findElement(finish).click();
        return new OverviewPage(driver);
    }
}
