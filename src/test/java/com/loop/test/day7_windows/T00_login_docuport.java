package com.loop.test.day7_windows;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class T00_login_docuport extends TestBase {

    @Test
    public void test_login_logout_docuport() throws InterruptedException {
        DocuportUtils.login(DocuportConstants.CLIENT);
        DocuportUtils.logOut();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(d-> driver.findElement(By.xpath("//label[text()='Username or email']")));

        DocuportUtils.login(DocuportConstants.ADVISOR);
        wait.until(d-> driver.findElement(By.xpath("//div[@class='v-avatar primary']")));
        DocuportUtils.logOut();

        wait.until(d-> driver.findElement(By.xpath("//label[text()='Username or email']")));
        DocuportUtils.login(DocuportConstants.EMPLOYEE);
        DocuportUtils.logOut();

        DocuportUtils.login(DocuportConstants.SUPERVISOR);
        DocuportUtils.logOut();
    }



}
