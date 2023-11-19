package com.loop.test.day3_locators_css_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLocatorsPractice {

    public static void main(String[] args) {

        //setup driver
        WebDriverManager.chromedriver().setup();

        //create driver instance
        WebDriver driver = new ChromeDriver();

        //naviage to
        driver.get("https://loopcamp.vercel.app/registration_form.html");

        driver.manage().window().maximize();

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Loop");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Academy");

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("lacademy");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("loop@loopacademy.com");

        //this will return three elements and click on the first one. we need to make sure the way we look for elements are unique.
        //WebElement gender = driver.findElement(By.name("gender"));
    }
}
