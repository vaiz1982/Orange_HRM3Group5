package Project3;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//3 of it for jptChatTest
import java.awt.Desktop;


public class chengePictureInMyInfoClass extends DriverClass {
    //Alexey Voytsekhovich


    @Test
    public void loginPart() {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement nameBox = driver.findElement(By.xpath("//input[@name='username']"));
        nameBox.sendKeys("Admin");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }

    @Test
    public void chengePictureInMyInfo() throws InterruptedException {
        loginPart();

        Thread.sleep(3000);
        //<span class="oxd-text oxd-text--span oxd-main-menu-item--name" data-v-7588b244="" data-v-4de0f1ff="">My Info</span>
        WebElement myInfoPage = driver.findElement(By.xpath("//span[text()='My Info']"));
        myInfoPage.click();

        //<img alt="profile picture" class="employee-image" src="/web/index.php/pim/viewPhoto/empNumber/7" data-v-09a26ef1="">
        //img[@class='employee-image']

        WebElement picture = driver.findElement(By.xpath("//img[@class='employee-image']"));
        picture.click();


        //<img alt="profile picture" class="employee-image" src="/web/index.php/../dist/img/user-default-400.png" data-v-449ec876="">
        WebElement getNewPicture = driver.findElement(By.xpath("//*[@class='employee-image-wrapper']"));
        getNewPicture.click();

//        String filePath = "/Desktop/girl.jpg";  ///Users/alexeyvoytsekhovich/Desktop/girl.jpg
//        WebElement chooseFile = driver.findElement(By.xpath("//button[@class='oxd-icon-button employee-image-action']"));
//        Thread.sleep(1000);  //hard wait
//        chooseFile.sendKeys(filePath);
//        Robot robot =new Robot();
//        robot.

    }

    //    @Test
//    public void RobotInWorkToGetPic() throws InterruptedException {
//        wait(5);
//        String pathForPicture="/Users/alexeyvoytsekhovich/Desktop/girl.jpg";
//        File file = new File(pathForPicture); //send path of the file
//
//
//        wait(5);
//        StringSelection StringSelection = new StringSelection(file.getAbsolutePath());
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(StringSelection, null);
//
//        wait(5);
//        driver.switchTo().window(driver.getWindowHandle());
//        try {
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_META);
//            robot.keyPress(KeyEvent.VK_W);
//            robot.keyRelease(KeyEvent.VK_META);
//            robot.keyRelease(KeyEvent.VK_W);
//            robot.keyPress(KeyEvent.VK_META);
//            robot.keyPress(KeyEvent.VK_SHIFT);
//            robot.keyPress(KeyEvent.VK_G);
//            robot.keyRelease(KeyEvent.VK_G);
//            robot.keyRelease(KeyEvent.VK_SHIFT);
//            robot.keyRelease(KeyEvent.VK_META);
//
//            // Paste the clipBoard content - Command ⌘ + V.
//            robot.keyPress(KeyEvent.VK_META);
//            robot.keyPress(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_META);
//
//            // Press Enter (GO - To bring up the file.)
//            robot.keyPress(KeyEvent.VK_ENTER);
//            robot.keyRelease(KeyEvent.VK_ENTER);
//            robot.delay( 1000 * 4 );
//
//            robot.keyPress(KeyEvent.VK_ENTER);
//            robot.keyRelease(KeyEvent.VK_ENTER);
//
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//    }
    @Test
//    import java.awt.Desktop;
//import java.io.File;
//import java.io.IOException;

    public void gptHelpWithOpenFile() throws IOException {
        while (true) {
            String pathForPicture = "/Users/alexeyvoytsekhovich//Desktop/girl.jpg.jpg";
            File file = new File(pathForPicture);
            Desktop.getDesktop().open(file);
        }
    }

    @Test
//    import java.awt.Desktop;
//import java.io.File;
//import java.io.IOException;

    public void openFileWithPath(String path) {
        String filePath = System.getProperty("user.home") + "/" + path;
        File file = new File(filePath);

        if (!file.exists()) {
            System.err.println("File not found: " + filePath);
            return;
        }

        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            System.err.println("Error opening file: " + e.getMessage());
        }
    }
}




