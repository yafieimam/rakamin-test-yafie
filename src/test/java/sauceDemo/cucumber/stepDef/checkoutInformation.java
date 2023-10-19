package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class checkoutInformation {
    WebDriver driver;
    String baseURL = "https://www.saucedemo.com/";

    @Given("Logged In Using Standard User for Checkout Information")
    public void logged_in_using_standard_user_for_checkout_information() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseURL);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String dashboardPageAssert = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals(dashboardPageAssert, "Products");
    }

    @When("Add Item to Cart for Checkout Information")
    public void add_item_to_cart_for_checkout_information() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack' and contains(text(), 'Add to cart')]")).click();
    }

    @And("Click Icon Cart for Checkout Information")
    public void click_icon_cart_for_checkout_information() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @And("Click Checkout Button for Checkout Information")
    public void click_checkout_button_for_checkout_information() {
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @And("Input First Name for Checkout Information")
    public void input_first_name_for_checkout_information() {
        driver.findElement(By.id("first-name")).sendKeys("Yafie");
    }

    @And("Input Last Name for Checkout Information")
    public void input_last_name_for_checkout_information() {
        driver.findElement(By.id("last-name")).sendKeys("Imam");
    }

    @And("Input Postal Code for Checkout Information")
    public void input_postal_code_for_checkout_information() {
        driver.findElement(By.id("postal-code")).sendKeys("12710");
    }

    @And("Click Continue Button for Checkout Information")
    public void click_continue_button_for_checkout_information() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("User Get Checkout Information Detail")
    public void user_get_checkout_information_detail() {
        String checkoutSuccessAssert = driver.findElement(By.xpath("//div[contains(text(), 'Payment Information')]")).getText();
        Assert.assertEquals(checkoutSuccessAssert, "Payment Information");
        driver.close();
    }

    @Then("User Get Error Message for Checkout Information")
    public void user_get_error_message_for_checkout_information() {
        String errorCheckoutAssert = driver.findElement(By.xpath("//h3[contains(text(), 'Error: First Name is required')]")).getText();
        Assert.assertEquals(errorCheckoutAssert, "Error: First Name is required");
        driver.close();
    }
}
