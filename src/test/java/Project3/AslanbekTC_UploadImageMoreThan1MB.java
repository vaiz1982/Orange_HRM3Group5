package Project3;

import Utilities.AslanbekPOMFile;
import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class AslanbekTC_UploadImageMoreThan1MB extends DriverClass {

    @Test
    public void uploadImageMoreThan1MB() throws AWTException {
        AslanbekPOMFile elements = new AslanbekPOMFile();
//        precondition: login as ESS user
//        Since it was impossible to automate creation of ESS account, this TC is doen on Admin account.
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        sendKeysElements(elements.username,"Admin");
        sendKeysElements(elements.password,"admin123");
        clickElements(elements.submitBtn);

//        Main part of the test
        Robot robot = new Robot();
        clickElements(elements.myInfo);
        clickElements(elements.img);
        clickElements(elements.addImg);
//        before running change the absolute path to the file. The file is in Images package.
        StringSelection stringSelection = new StringSelection("\"C:\\Users\\aslan\\IdeaProjects\\Orange_HRM3Group5\\src\\test\\java\\Images\\highresolutionfile.jpg\"");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        wait(1);
        clipboard.setContents(stringSelection, stringSelection);
        wait(1);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        wait(1);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        wait(1);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        wait(1);
        String afterImg = elements.docFile.getText();
        /**Expected result:
         * "The ""Photograph screen"" will be displayed
         *
         * You will be able to browse your local machine for images
         *
         * The file name is selected in the ""Choose a file"" box
         *
         * An error message is displayed that the format is not supported- <The exact error message>"*/
        Assert.assertEquals(afterImg, "Attachment Size Exceeded", "error is not as expected");
        Assert.assertTrue(elements.docFile.isDisplayed(), "Error message was not displayed");


    }
}
