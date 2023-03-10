package Project3;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestJPGProfilePicture extends DriverClass {

    @Test(enabled = false)
    public void login() {


        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement nameBox = driver.findElement(By.xpath("//input[@name='username']"));
        sendKeysElements(nameBox, "Admin");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        sendKeysElements(passwordBox, "admin123");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        clickElements(loginButton);
    }

    @Test(enabled = false)
    public void changePicture() throws AWTException {

        login();

        WebElement myInfo = driver.findElement(By.xpath("//span[normalize-space()='My Info']"));
        clickElements(myInfo);

        WebElement profilePicture = driver.findElement(By.xpath("//img[@class='employee-image']"));
        clickElements(profilePicture);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement addButton = driver.findElement(By.cssSelector("button[class='oxd-icon-button employee-image-action']"));
        clickElements(addButton);

        Robot robot = new Robot();
        StringSelection stringSelection = new StringSelection("\"C:\\Users\\serca\\OneDrive\\Desktop\\test data\\AA18oUJN.jpg\"");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        wait(1);
        clipboard.setContents(stringSelection, stringSelection);


        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        wait(1);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        wait(1);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        wait(3);

        WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
        clickElements(saveButton);

    }
    @Test
    public void validation() throws AWTException {

        changePicture();

        WebElement successMessage = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")));

        Assert.assertTrue(successMessage.isDisplayed());

    }
}
