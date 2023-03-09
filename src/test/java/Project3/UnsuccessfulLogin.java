package Project3;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnsuccessfulLogin extends DriverClass {

    @Test
    void loginTest() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("abc123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
        String result = errorMessage.getText();
        Assert.assertEquals(result,"Invalid credentials");



    }


}
