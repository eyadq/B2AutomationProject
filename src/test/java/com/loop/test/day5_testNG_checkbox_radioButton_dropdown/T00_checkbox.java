package com.loop.test.day5_testNG_checkbox_radioButton_dropdown;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class T00_checkbox {

        /*
        1. Go to http://the-internet.herokuapp.com/checkboxes
        2. Confirm checkbox #1 is NOT selected by default
        3. Confirm checkbox #2 is SELECTED by default.
        4. Click checkbox #1 to select it.
        5. Click checkbox #2 to deselect it.
        6. Confirm checkbox #1 is SELECTED.
        7. Confirm checkbox #2 is NOT selected.

         */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        //wait the whole page loads - selenium 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        List<WebElement> checkboxList = driver.findElements(By.xpath("//form[@id='checkboxes']"));
//        System.out.println(checkboxList.get(0).isSelected());

        WebElement checkBox1 = driver.findElement(By.xpath("//input/following-sibling::text()[contains(.,'checkbox 1')]/preceding-sibling::input"));
        if(!checkBox1.isSelected()){
            System.out.println("Checkbox is not selected");
        } else {
            System.out.println("Checkbox is selected");
        }

        checkBox1.click();

        if(checkBox1.isSelected()){
            System.out.println("Checkbox is selected");
        } else {
            System.out.println("Checkbox is not selected");
        }

        WebElement checkBox2 = driver.findElement(By.xpath("//input/following-sibling::text()[contains(., 'checkbox 2')]/preceding-sibling::input/following-sibling::input"));


    }
}
