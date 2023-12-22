package com.loop.test.day7_windows;

import org.openqa.selenium.WebDriver;

import java.util.Set;

import static org.testng.AssertJUnit.assertTrue;

public class BrowserUtils {

    /**
     * Validate if driver switched to expected URL and Title
     * @param driver
     * @param expectedURL
     * @param expectedTitle
     * @author eyadq
     * implements assertion
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedURL, String expectedTitle){
        expectedTitle = expectedTitle.toLowerCase();
        expectedURL = expectedURL.toLowerCase();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if(driver.getCurrentUrl().toLowerCase().contains(expectedURL)){
                break;
            }
            assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
        }

    }

    /**
     * Switches to the window by the eact title
     * Return to the original window if window with given title is not found
     * @parm driver
     * @parm targetTitle
     */
    public static void switchToWindow(WebDriver driver, String targetTitle){
        String original = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
            driver.switchTo().window(original);
        }
    }
}
