package com.loop.test.day8_webtables_config;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.DocuportWebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_webTables extends TestBase {

        /*
    1. login as an advisor
    2. go to users
    3. validate that full name for alex.de.souza@gmail.com is Alex De Souza
    4. validate that user name for alex.de.souza@gmail.com is alexdesouze
    5. validate that phone number for alex.de.souza@gmail.com is +994512060042
    6. validate that role for alex.de.souza@gmail.com is client
    7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
     */

    @Test
    public void testWebTables() throws InterruptedException {

        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement users = driver.findElement(By.xpath("//a[@href='/users']"));
        users.click();

        String expectedFullName = "Alex De Souza";
        String actualFullName = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Full name");
        Assert.assertEquals(actualFullName, expectedFullName, "Full name did not match expected");

        String expectedUserName = "alexdesouze";
        String actualUserName = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "username");
        Assert.assertEquals(actualUserName, expectedUserName, "Username did not match expected");

    }

    @Test
    public void testUser() throws InterruptedException {

        DocuportUtils.login(driver, "advisor");



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement users = driver.findElement(By.xpath("//a[@href='/users']"));
        users.click();

        WebElement name = driver.findElement(By.xpath("//span[text()='Alex De Souza']"));
        String actualName = name.getText();
        Assert.assertEquals(actualName, "Alex De Souza", "full name");

        WebElement username = driver.findElement(By.xpath("//td[text()='alexdesouze']"));
        String actualUsername = username.getText();
        Assert.assertEquals(actualUsername, "alexdesouze", "username");

        WebElement phoneNumber = driver.findElement(By.xpath("//span[text()='+994512060042']"));
        String actualPhoneNumber = phoneNumber.getText();
        Assert.assertEquals(actualPhoneNumber, "+994512060042", "phone number");

        WebElement email = driver.findElement(By.xpath("//td[text()='alex.de.souza@gmail.com']"));
        String actualEmail = email.getText();
        Assert.assertEquals(actualEmail, "alex.de.souza@gmail.com", "email address");

        WebElement account = driver.findElement(By.xpath("//span[text()='+994512060042']//parent::td//following-sibling::td//child::span//child::span"));
        String actualAccount = account.getText();
        Assert.assertEquals(actualAccount, "Client", "account type should be client");

        WebElement batch = driver.findElement(By.xpath("//span[text()='+994512060042']//parent::td//following-sibling::td//following-sibling::td"));
        String actualBatch = batch.getText();
        Assert.assertEquals(actualBatch, "Batch1 Group1", "Batch number");




    }
}
