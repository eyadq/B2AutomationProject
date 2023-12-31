package com.loop.test.day10_upload_download;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_drag_drop {

    /*
1- Open a chrome browser
2- Go to: https://demo.guru99.com/test/drag_drop.html
3- Drag “BANK” and drop into Account area under Debit Side
4- Drag “5000” and drop into Amount area under Debit Side
5- Drag “SALES” and drop into Account area under Credit Side
6- Drag “5000” and drop into Amount area under Credit Side
7- Validate “Perfect!” text displayed.
 */
    @Test
    public void drag_drop_test(){

        Driver.getDriver().get(ConfigurationReader.getProperty("guru.drag"));
        WebElement bank = Driver.getDriver().findElement(By.xpath("//a[text()=' BANK ']"));
        WebElement debitAccount = Driver.getDriver().findElement(By.id("bank"));
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(bank, debitAccount).perform();

        WebElement fiveK = Driver.getDriver().findElement(By.xpath("//a[text()=' 5000 ']"));
        WebElement debitAmount = Driver.getDriver().findElement(By.id("amt7"));
        actions.dragAndDrop(fiveK, debitAmount).perform();

        WebElement sales = Driver.getDriver().findElement(By.xpath("//a[text()=' SALES ']"));
        WebElement creditAccount = Driver.getDriver().findElement(By.xpath("//*[@id='loan']/li"));         actions.dragAndDrop(sales, creditAccount).perform();

        WebElement creditAmount = Driver.getDriver().findElement(By.id("amt8"));
        actions.dragAndDrop(fiveK, creditAmount).perform();

        WebElement perfect = Driver.getDriver().findElement(By.xpath("//a[text()='Perfect!']"));
        Assert.assertEquals(perfect.getText(), "Perfect!");


    }
}
