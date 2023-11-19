package com.loop.test.day3_locators_css_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) {
        //setup driver
        WebDriverManager.chromedriver().setup();

        //create driver instance
        WebDriver driver = new ChromeDriver();

        //navigate to Google
        driver.get("https://www.google.com");

        //maximize the window
        driver.manage().window().maximize();

        //locate the element
        WebElement searchBoxWithID = driver.findElement(By.id("APjFqb"));
        WebElement searchBoxWithName = driver.findElement(By.name("q"));
        WebElement aboutLink = driver.findElement(By.linkText("About"));

        //aboutLink.click();

        //create a String with search term
        searchBoxWithID.sendKeys("Original Text to send first");
        searchBoxWithID.clear();
        String textToSearch = "Loop Academy";

        searchBoxWithID.sendKeys(textToSearch + Keys.ENTER);

        String expectedURL = "https://www.google.com/search?q=Loop+Academy&sca_esv=583796676&source=hp&ei=5TdaZaeuCtulqtsPgPOI4AI&iflsig=AO6bgOgAAAAAZVpF9Z_PjCuD48j1f0qpNT8Na5D6p-UW&ved=0ahUKEwjntJL7vdCCAxXbkmoFHYA5AiwQ4dUDCAw&uact=5&oq=Loop+Academy&gs_lp=Egdnd3Mtd2l6IgxMb29wIEFjYWRlbXkyBRAAGIAEMgsQLhiABBjHARivATIGEAAYFhgeMgYQABgWGB4yBhAAGBYYHjIGEAAYFhgeMgYQABgWGB4yBhAAGBYYHjIGEAAYFhgeMgYQABgWGB5IwekQULsKWPcccAN4AJABAJgBYKABvQaqAQIxMbgBA8gBAPgBAagCCsICEBAAGAMYjwEY5QIY6gIYjAPCAhIQABgDGI8BGOUCGOoCGAoYjAPCAhAQLhgDGI8BGOUCGOoCGIwDwgIREC4YgAQYsQMYgwEYxwEY0QPCAg4QLhiDARixAxiABBiKBcICDhAuGIAEGLEDGMcBGNEDwgIOEC4YgAQYigUYsQMYgwHCAgsQLhiABBixAxiDAcICCxAAGIAEGLEDGIMBwgIFEC4YgATCAggQABiABBixA8ICERAuGIAEGLEDGMkDGMcBGNEDwgIIEAAYgAQYkgPCAgsQABiABBiKBRiSA8ICDhAuGIAEGLEDGIMBGNQCwgIOEAAYgAQYigUYsQMYgwHCAggQLhiABBixA8ICEBAuGIAEGMkDGMcBGNEDGArCAgsQLhiABBjHARjRAw&sclient=gws-wiz";
        String actualURL = driver.getCurrentUrl();
        if(actualURL.contains("Loop")){
            System.out.println("Actual url:  matches expected URL:   => TEST PASS");
        } else {
            System.err.println("Actual URL: DOES NOT match expected URL:  => TEST FAIL");
        }


        //WebElement enterSearchButton = driver.findElement(By.name("btnK"));
        //enterSearchButton.click();

        //searchBoxWithID.submit(); //Keys.ENTER does same thing

        //quit
        driver.quit();
    }
}
