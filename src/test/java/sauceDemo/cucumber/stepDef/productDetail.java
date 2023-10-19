package sauceDemo.cucumber.stepDef;

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

public class productDetail {
    WebDriver driver;
    String baseURL = "https://www.saucedemo.com/";
    String titleProduct;

    @Given("Logged In Using Standard User for Product Detail")
    public void logged_in_using_standard_user_for_product_detail() {
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

    @When("Click Product Title")
    public void click_product_title() {
        titleProduct = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Backpack')]")).getText();
        driver.findElement(By.xpath("//a[@id='item_4_title_link']")).click();
    }

    @Then("User Get Product Detail Correctly")
    public void user_get_product_detail_correctly() {
        try {
            String titleProductNow = driver.findElement(By.xpath("//div[contains(text(), '" + titleProduct + "')]")).getText();
            driver.close();
        } catch (NoSuchElementException e) {
            System.out.println("Product Detail Page Not Correct");
            driver.quit();
        }
    }

    @Given("Logged In Using Problem User for Product Detail")
    public void logged_in_using_problem_user_for_product_detail() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseURL);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String dashboardPageAssert = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals(dashboardPageAssert, "Products");
    }

    @Then("User Get Product Detail Incorrectly")
    public void user_get_product_detail_incorrectly() {
        try {
            String titleProductNow = driver.findElement(By.xpath("//div[contains(text(), '" + titleProduct + "')]")).getText();
            driver.close();
        } catch (NoSuchElementException e) {
            System.out.println("Product Detail Page Not Correct");
            driver.quit();
        }
    }
}
