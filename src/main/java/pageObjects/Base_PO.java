package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base_PO {
    public Base_PO(){
    }
    public WebDriver getDriver(){
        return DriverFactory.getDriver();
    }
    public void navigateTo_URL(String url){
        getDriver().get(url);
    }
    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }
    public void sendKeys(By by, String textToType){
        //max wait is 10 seconds
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        //wait until element is to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys((textToType));
}
}
