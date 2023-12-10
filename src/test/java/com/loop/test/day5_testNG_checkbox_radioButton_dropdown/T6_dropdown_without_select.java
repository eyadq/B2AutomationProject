package com.loop.test.day5_testNG_checkbox_radioButton_dropdown;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T6_dropdown_without_select {

    WebDriver driver;

    @Test
    public void testDropDown(){
        WebElement userName = driver.findElement(By.xpath("//input[@id='input-14']"));
        WebElement passWord = driver.findElement(By.xpath("//input[@id='input-15']"));
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));

        userName.sendKeys(DocuportConstants.USERNAME_ADVISOR);
        passWord.sendKeys(DocuportConstants.PASSWORD_ADVISOR);
        login.click();

        WebElement recieved = driver.findElement(By.xpath("//span[text()='Received docs']"));
        recieved.click();

        WebElement search = driver.findElement(By.xpath("//span[.='Search']"));
        search.click();

        WebElement statusButton = driver.findElement(By.xpath("//div[@class='v-select__slot']/label[contains(.,'Status')]"));
        statusButton.click();

        WebElement progressButton = driver.findElement(By.xpath("//div[text()='In progress']"));
        progressButton.click();

    }

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
