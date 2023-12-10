package com.loop.test.day6_alerts_iframes;

import com.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_alerts extends TestBase {

    /*
    Information alert practice
    1. Open browser
    2. Go to website: https://loopcamp.vercel.app/javascript-alerts.html
    3. Click to “Click for JS Alert” button
    4. Click to OK button from the alert
    5. Validate “You successfully clicked an alert” text is displayed

    Confirmation alert practice
    1. Click to “Click for JS Confirm” button
    2. Click to OK button from the alert
    3. Verify “You clicked: Ok” text is displayed.
    4. Click to “Click for JS Confirm” button
    5. Click to Cancel button from the alert
    6. Validate “You clicked: Cancel” text is displayed.

    Prompt alert practice
    1. Click to “Click for JS Prompt” button
    2. Send "Loop Academy"
    3. Click Ok
    4. Validate "You entered: Loop Academy" text is displayed


     */

    @Test
    public void informationAlert() {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        clickForJSAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement successMessageForInformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You successfully clicked an alert";
        String actual = successMessageForInformationAlert.getText();
        Assert.assertEquals(actual, expected, "Message from accepting first alert, actual did not match expected");
    }

    @Test
    public void conformationAlert(){
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        clickForJSConfirm.click();
        driver.switchTo().alert().accept();

        WebElement successMessageForInformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You clicked: Ok";
        String actual = successMessageForInformationAlert.getText();
        Assert.assertEquals(actual, expected, "Message from accepting confirm alert, actual did not match expected");

        clickForJSConfirm.click();
        driver.switchTo().alert().dismiss();
        expected = "You clicked: Cancel";
        actual = successMessageForInformationAlert.getText();
        Assert.assertEquals(actual, expected, "Message from dismissing confirm alert, actual did not match expected");
    }

    @Test
    public void promptAlert() {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSPrompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        clickForJSPrompt.click();
        String text = "Loop Academy";
//        driver.switchTo().alert().sendKeys(text);
//        driver.switchTo().alert().accept();
        //Alternative way
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();

        WebElement successMessageForInformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You entered: " + text;
        String actual = successMessageForInformationAlert.getText();
        Assert.assertEquals(actual, expected, "Message from accepting prompt alert, actual did not match expected");
    }

}
