package com.loop.test.day5_testNG_checkbox_radioButton_dropdown;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T000_staleElementException {

    /*
        1. Open Chrome browser
        2. Go to http://the-internet.herokuapp.com/add_remove_elements/
        3. Click to “Add Element” button
        4. Verify “Delete” button is displayed after clicking.
        5. Click to “Delete” button.
        6. Verify “Delete” button is NOT displayed after clicking.
        USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
         */

    public static void main(String[] args) {

        //open the browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));
        if(deleteButton.isDisplayed()){
            System.out.println("Delete button is displayed");
        } else {
            System.out.println("Delete button is not displayed");
        }

        deleteButton.click();


        try {

            deleteButton.isDisplayed();

        } catch (StaleElementReferenceException e) {
            System.out.println("Exception handled");
            System.out.println("Element is not displayed anymore");
        }


    }
}
