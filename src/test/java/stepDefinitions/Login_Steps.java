package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Login_Steps {
    private WebDriver driver;


    //Hook that is used for setting up the environment before initial scenario step, executes before every scenario.
    @Before("@login")
    public void setup(){
        //Since driver is in the project, we are making sure that it is going to run in any windows machine that has Chrome Version 104.
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        //choosing normal so Selenium WebDriver will wait for the entire page is loaded. We can use waitUntil between steps as well yet this is more efficient.
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        //open window on full screen
        driver.manage().window().maximize();
    }
    //Hook thats used for after scenario settings.
    @After("@login")
    public void tearDown(){
        driver.quit();
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
            driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html");
    }
    @When("I enter a username {string}")
    public void i_enter_a_username(String username) {
            driver.findElement(By.id("text")).sendKeys(username);
    }
    @When("I enter a username {word}")
    public void i_enter_a_unique_username(String username) {
        driver.findElement(By.id("text")).sendKeys(username);
    }
    @And("I enter a password {}")
    public void i_enter_a_password_webdriver123(String password) {
            driver.findElement(By.id("password")).sendKeys(password);
    }
    @And("I click on the login button")
    public void i_click_on_the_login_button() {
            driver.findElement(By.id("login-button")).click();
    }
    @Then("I should be presented with the successful login message")
    public void i_should_be_presented_with_the_successful_login_message() {
            String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message,"validation succeeded");
    }

    @Then("I should be presented with the unsuccessful login message")
    public void iShouldBePresentedWithTheUnsuccessfulLoginMessage() {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message,"validation failed");
    }

    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message(String expectedMessage) {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message,expectedMessage);
    }
}
