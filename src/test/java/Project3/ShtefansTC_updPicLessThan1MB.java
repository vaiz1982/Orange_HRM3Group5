package Project3;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;


public class ShtefansTC_updPicLessThan1MB extends DriverClass {


        @Test(description = "Test to Login to OrangeHRM as an Admin")
        public void login() {
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            wait(1);
            WebElement username = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
            WebElement password = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
            // username.click();
            username.sendKeys("Admin");
            password.sendKeys("admin123");
        }

    @Test(description = "Upload of Invalid picture format which is less than 1 MB")
    void uploadPicture() {

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();

        wait(1);


        WebElement myInfo = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a"));
        myInfo.click();

        wait(1);

        WebElement profileIcon = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[2]/div/img"));
        profileIcon.click();

        wait(1);

        WebElement addPhoto = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div/form/div[1]/div/div/div[2]/div/button/i"));
        addPhoto.click();
        /* addPhoto.sendKeys("/Users/shtefanuz/Desktop/face");
         *//*addPhoto.sendKeys(Keys.ENTER);*//*
         */

        /** SIDE NOTE: THE ROBOT CLASS ISN'T WORKING PROPERLY! THE CODE BELOW IS PROVIDED BY NEBAHAT */

        // copying File path to Clipboard
        String pathForPicture = "/Users/shtefanuz/Desktop/Friends.JPG";
        File file = new File(pathForPicture); //send path of the file

        StringSelection StringSelection = new StringSelection(file.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(StringSelection, null);

        driver.switchTo().window(driver.getWindowHandle());
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_W);
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_META);

            // Paste the clipBoard content - Command ⌘ + V.
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_META);

            // Press Enter (GO - To bring up the file.)
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(1000 * 4);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (AWTException e) {
            e.printStackTrace();
        }

        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div/form/div[2]/button"));
        saveButton.click();

        wait(5);

    }
}