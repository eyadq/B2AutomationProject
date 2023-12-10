package com.loop.test.day6_alerts_iframes;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class T2_iframe extends TestBase {

            /*
    1- Open a chrome browser
    2- Go to: https://loopcamp.vercel.app/iframe.html
    3- Clear text from comment body
    4- Type "Loop Academy" in comment body
    5- Verify "Loop Academy" text is written in comment body
    6- Verify header "An iFrame containing the TinyMCE WYSIWYG Editor" is displayed

     */

    @Test
    public void iframeTest(){
        driver.get("https://loopcamp.vercel.app/tinymce.html");

        //Switch to frame by WebElement
        //WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        //driver.switchTo().frame(iframe);

        //Switch to frame by WebElement (one line)
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

        //Switch frame by ID or name (ID in this case)
        //driver.switchTo().frame("mce_0_ifr");

        //Switch by index (Only one iframe on this page)
        driver.switchTo().frame(0);

        WebElement textbox = driver.findElement(By.id("tinymce"));
        textbox.clear();
        //String text = "Loop Academy";
        //textbox.sendKeys(text);

        //Switch back to original (most outer frame)
        //driver.switchTo().defaultContent();

        //Switch UP one frame (goes one layer at most)
        driver.switchTo().parentFrame();

        WebElement poweredByLoopcamp = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        Assert.assertEquals(poweredByLoopcamp.getText(), "Powered by LOOPCAMP", "Powered by loopcamp footer text");

        WebElement header = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        String actual = header.getText();
        String expected = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actual, expected, "Header text actual doesnt match expected");
    }

    @Test
    public void amazonIframe(){
        driver.get("https://www.amazon.com");
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println(frames.size());
    }

}
