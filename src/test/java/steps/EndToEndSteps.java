package steps;

import Pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Map;

public class EndToEndSteps {

    private WebDriver driver;
    private loginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private OverviewPage overviewPage;
    private CompletePage completePage;

    @Given("User launches the SwagLabs")
    public void user_launches_the_swag_labs() {
        driver = new FirefoxDriver();
        loginPage = new loginPage(driver);
        loginPage.Setup();
    }

    @Given("user navigate to SwagLabs URL")
    public void user_navigate_to_swag_labs_url() {
        loginPage.navigateToSwaglabsURL();
    }

    @When("User attempts to login with below valid credentials")
    public void user_attempts_to_login_with_valid_credentials(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        loginPage.FillUserNameAndPassword(credentials.get(0).get("username"), credentials.get(0).get("password"));
    }

    @Then("user should be directed to product catalog page")
    public void user_should_be_directed_to_product_catalog_page() {
        System.out.println(driver.findElement(new ProductsPage(driver).shoppingCartLocator).isDisplayed());
    }

    @And("Add the First and Second Products To The Cart and Click On The Cart Icon")
    public void Add_the_First_and_Second_Products_To_The_Cart_and_Click_On_The_Cart_Icon() {
        productsPage = new ProductsPage(driver);
        productsPage.AddProductsToTheCart();
    }

    @Then("User Should be in Cart Page And able to see his products")
    public void user_should_be_in_cart_page_and_able_to_see_his_products() {
        cartPage = new CartPage(driver);
        System.out.println(driver.findElement(cartPage.YourCartSpan).isDisplayed());
    }

    @Then("Click On Checkout")
    public void click_on_checkout() {
        cartPage.ClickOnCheckout();
    }

    @Then("User Should be in Checkout Page")
    public void user_should_be_in_checkout_page() {
        checkoutPage = new CheckoutPage(driver);
        System.out.println(driver.findElement(checkoutPage.Continue).isDisplayed());
    }

    @Then("user Fill The information with below valid credentials And Click On Continue")
    public void user_fill_the_information_with_below_valid_credentials_and_click_on_continue(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        checkoutPage.FillInformationAndClickOnContinue(credentials.get(0).get("firstName"), credentials.get(0).get("LastName"), credentials.get(0).get("ZipCode"));
    }

    @Then("user should be in Overview page")
    public void user_should_be_in_overview_page() {
        overviewPage = new OverviewPage(driver);
        System.out.println(driver.findElement(overviewPage.finish).isDisplayed());
    }

    @Then("click on Finish")
    public void click_on_finish() {
        overviewPage.ClickOnFinish();
    }

    @Then("user Should be in Complete page see a message Thank you for your order")
    public void user_should_be_in_complete_page_see_a_message_thank_you_for_your_order() {
        completePage = new CompletePage(driver);
        driver.findElement(completePage.Message).isDisplayed();
        driver.quit();
    }

}
