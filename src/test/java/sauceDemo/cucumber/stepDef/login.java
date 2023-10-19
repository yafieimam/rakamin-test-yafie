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

public class login {
    WebDriver driver;
    String baseURL = "https://www.saucedemo.com/";

    @Given("Login Page Sauce Demo App")
    public void login_page_sauce_demo_app() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseURL);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("Input Username")
    public void input_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input Password")
    public void input_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User Click Login Button")
    public void user_click_login_button() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("User Redirect to Home Page")
    public void user_redirect_to_home_page() {
//        driver.findElement(By.xpath("//div[contains(text(), 'dashboard')]"));
        String dashboardPageAssert = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals(dashboardPageAssert, "Products");
        driver.close();
    }

    @When("Input Invalid Username")
    public void input_invalid_username() {
        driver.findElement(By.id("user-name")).sendKeys("yafieimam");
    }

    @And("Input Invalid Password")
    public void input_invalid_password() {
        driver.findElement(By.id("password")).sendKeys("test123");
    }

    @Then("User Get Error Message")
    public void user_get_error_message() {
        String errorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}
