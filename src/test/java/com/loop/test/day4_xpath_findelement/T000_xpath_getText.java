package com.loop.test.day4_xpath_findelement;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.*;

public class T000_xpath_getText {

         /*
    1. Open Chrome browser
    2. Go to docuport
    3. Click on forgot password
    4. validate URL contains: reset-password
    5. validate - Enter the email address associated with your account
    6. enter forgotpasswordg1@gmail.com to email box
    7. validate cancel button is displayed
    8. validate send button is displayed
    9. click send button
    10. validate - We've sent you an email with a link to reset your password. Please check your email
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");

        WebElement forgotPasswordLink = driver.findElement(By.xpath("//a[@href='/reset-password']"));
        forgotPasswordLink.click();

        String URL = driver.getCurrentUrl();
        if(URL.equals(DocuportConstants.RESET_PASSWORD_URL)){
            System.out.println("The actual URL: \"" + URL + "\" matches expected URL: \"" + DocuportConstants.RESET_PASSWORD_URL + "\" => TEST PASSED");
        } else {
            System.out.println("The actual URL: \"" + URL + "\" does not match  expected URL: \"" + DocuportConstants.RESET_PASSWORD_URL + "\" => TEST FAILED");
        }

        WebElement validateMessage = driver.findElement(By.xpath("//div[@class='v-messages__message']"));
        String actualValidateMessage = validateMessage.getText();

        if(actualValidateMessage.equals(DocuportConstants.RESET_PASSWORD_MESSAGE)){
            System.out.println("The actual message: \"" + actualValidateMessage + "\" matches expected text: \"" + DocuportConstants.RESET_PASSWORD_MESSAGE + "\" =>  TEST PASSED");
        } else {
            System.out.println("The actual message: \"" + actualValidateMessage + "\" does not match  expected text: \"" + DocuportConstants.RESET_PASSWORD_MESSAGE + "\" => TEST FAILED");
        }


        WebElement emailInputBox = driver.findElement(By.xpath("//input[@type='email']"));
        emailInputBox.sendKeys(DocuportConstants.EMAIL_FOR_RESET_PASSWORD);

        // 7. validate cancel button is displayed
        WebElement cancelButton = driver.findElement(By.xpath("//span[normalize-space() = 'Cancel']"));
        WebElement sendButton = driver.findElement(By.xpath("//span[normalize-space() = 'Send']"));

        if(cancelButton.isDisplayed()){
            System.out.println("The cancel button is displayed");
        } else {
            System.out.println("The cancel button is NOT displayed");
        }

        if(sendButton.isDisplayed()){
            System.out.println("The send button is displayed");
        } else {
            System.out.println("The send button is NOT displayed");
        }

        sendButton.click();

        Thread.sleep(2000);

        WebElement successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));

        //Thread.sleep(5000);

        try{
            System.out.println(successMessage.getText());

        } catch (StaleElementReferenceException e){
            System.out.println("Element is not there anymore");
            e.printStackTrace();
        }




    }
}
