package com.loop.test.day4_xpath_findelement;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T00_css_isDisplayed {

     /*
    http://the-internet.herokuapp.com/forgot_password
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/forgot_password");

        WebElement forgotPasswordHeading = driver.findElement(By.cssSelector("div[class='example']>h2"));

        if(forgotPasswordHeading.isDisplayed()){
            System.out.println("Forgot password heading is displayed");
        } else {
            System.out.println("Forgot password heading is NOT displayed");
        }

    }
}
