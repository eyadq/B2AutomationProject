package com.loop.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        //Setting up the web driver
        WebDriverManager.chromedriver().setup();

        //Create instance of webdriver
        WebDriver driver = new ChromeDriver();
        //Thread.sleep(5000);

        //Navigate to web page
        driver.get("https://google.com");
        //driver.navigate().to("https://google.com");

        //Maximize the window
        //driver.manage().window().maximize();
        driver.manage().window().fullscreen();

        driver.navigate().to("https://etsy.com");

        //Nivigate back
        driver.navigate().back();

        //Navigate forward
        driver.navigate().forward();

        driver.navigate().refresh();

        //quit close
        //driver.quit(); //the program will stop
        driver.close(); //the web page closes but the program still runs
    }
}
