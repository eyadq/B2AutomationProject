package com.loop.test.day7_windows;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class T00_login_docuport extends TestBase {

    @Test
    public void test_login_logout_docuport() throws InterruptedException {
        DocuportUtils.login(driver, DocuportConstants.CLIENT);
        DocuportUtils.logOut(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d-> driver.findElement(By.xpath("//label[text()='Username or email']")));

        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        wait.until(d-> driver.findElement(By.xpath("//div[@class='v-avatar primary']")));
        DocuportUtils.logOut(driver);

        wait.until(d-> driver.findElement(By.xpath("//label[text()='Username or email']")));
        DocuportUtils.login(driver, DocuportConstants.EMPLOYEE);
        DocuportUtils.logOut(driver);

        DocuportUtils.login(driver, DocuportConstants.SUPERVISOR);
        DocuportUtils.logOut(driver);
    }



}
