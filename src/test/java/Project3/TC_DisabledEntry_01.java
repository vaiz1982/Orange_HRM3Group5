package Project3;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_DisabledEntry_01 extends DriverClass {
    /**
     * 1- Go to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
     * 2- Log-in saniashaheen pass: Shaheen123!
     * 3- Navigate My Info page
     * 4- Verify Employee ID, SSN No, SIN No, Driver License No, Date of Birth disabled for entry
     */

    @Test
    void disabledEntry() {
        //STEP 1
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //STEP 2
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("saniashaheen");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("Shaheen123!");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        //STEP 3
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='oxd-main-menu-item-wrapper'])[3]")));
        WebElement myInfo = driver.findElement(By.xpath("(//li[@class='oxd-main-menu-item-wrapper'])[3]"));
        myInfo.click();

        //STEP 4.1 EmployeeID
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")));
        boolean employeeIDBox = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).isEnabled();
        Assert.assertFalse(employeeIDBox);
        System.out.println("Employee ID Box Disabled For Entry");

        //STEP 4.2 Driver License Number
        boolean driverLicenseBox = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[5]")).isEnabled();
        Assert.assertFalse(driverLicenseBox);
        System.out.println("Driver License Box Disabled For Entry");

        //STEP 4.3 SSN
        boolean SSNBox = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[7]")).isEnabled();
        Assert.assertFalse(SSNBox);
        System.out.println("SSN Box Disabled For Entry");

        //STEP 4.4 SIN
        boolean SINBox = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[8]")).isEnabled();
        Assert.assertFalse(SINBox);
        System.out.println("SIN Box Disabled For Entry");

        //STEP 4.5 Date Of Birth
        boolean dateOfBirth = driver.findElement(By.xpath("(//input[@placeholder='yyyy-mm-dd'])[2]")).isEnabled();
        Assert.assertFalse(dateOfBirth);
        System.out.println("Date Of Birth Box Disabled For Entry");
    }
}

