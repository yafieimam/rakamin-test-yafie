package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class checkout {
    WebDriver driver;
    String baseURL = "https://www.saucedemo.com/";

    @Given("Logged In Using Standard User for Checkout")
    public void logged_in_using_standard_user_for_checkout() {
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

    @When("Add Item to Cart for Checkout")
    public void add_item_to_cart_for_checkout() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack' and contains(text(), 'Add to cart')]")).click();
    }

    @And("Click Icon Cart for Checkout")
    public void click_icon_cart_for_checkout() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @And("Click Checkout Button for Checkout")
    public void click_checkout_button_for_checkout() {
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @And("Input First Name for Checkout")
    public void input_first_name_for_checkout() {
        driver.findElement(By.id("first-name")).sendKeys("Yafie");
    }

    @And("Input Last Name for Checkout")
    public void input_last_name_for_checkout() {
        driver.findElement(By.id("last-name")).sendKeys("Imam");
    }

    @And("Input Postal Code for Checkout")
    public void input_postal_code_for_checkout() {
        driver.findElement(By.id("postal-code")).sendKeys("12710");
    }

    @And("Click Continue Button for Checkout")
    public void click_continue_button_for_checkout() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @And("Click Finish Button for Checkout")
    public void click_finish_button_for_checkout() {
        driver.findElement(By.xpath("//button[@id='finish']")).click();
    }

    @Then("User Get Checkout Information Finished")
    public void user_get_checkout_information_finished() {
        String checkoutFinishAssert = driver.findElement(By.xpath("//h2[contains(text(), 'Thank you for your order!')]")).getText();
        Assert.assertEquals(checkoutFinishAssert, "Thank you for your order!");
        driver.close();
    }

    @Then("User Get Error Message for Checkout")
    public void user_get_error_message_for_checkout() {
        try {
            String errorCheckout = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
            Assert.assertEquals(errorCheckout, "Error: no items in cart");
            driver.close();
        } catch (NoSuchElementException e) {
            System.out.println("No Error Message");
            driver.quit();
        }
    }
}
